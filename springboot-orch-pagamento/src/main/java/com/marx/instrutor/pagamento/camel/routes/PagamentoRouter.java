package com.marx.instrutor.pagamento.camel.routes;

import org.apache.camel.ExchangePattern;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.marx.instrutor.pagamento.camel.predicates.VerificarSaldoPredicate;
import com.marx.instrutor.pagamento.camel.processor.AtualizarSaldoContaCorrenteProcessor;
import com.marx.instrutor.pagamento.camel.processor.ConsultaContaCorrenteProcessor;
import com.marx.instrutor.pagamento.camel.processor.EfetivarPagamentoProcessor;
import com.marx.instrutor.pagamento.exception.SaldoIndisponivelException;
import com.marx.instrutor.representation.ContaCorrenteRepresentation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PagamentoRouter extends RouteBuilder {

	@Value("${app.url.contacorrente}")
	private String urlContaCorrente;

	@Value("${app.url.pagamento}")
	private String urlPagamento;
	
	public void configure() {    	
		
		from(fromPagamentoQueue())
        		.setExchangePattern(ExchangePattern.InOnly)
                .log(LoggingLevel.INFO, log, "${body}")
                .setProperty("initialPayload", simple("${body}"))
                .process(new ConsultaContaCorrenteProcessor())
                .to(ExchangePattern.InOnly, urlContaCorrente)
                .unmarshal().json(JsonLibrary.Jackson, ContaCorrenteRepresentation.class)
                .choice()
                	.when(new VerificarSaldoPredicate())
                		.process(new EfetivarPagamentoProcessor())
                		.marshal().json(JsonLibrary.Jackson, HttpEntity.class)
                		.to(ExchangePattern.InOnly, urlPagamento)
                		.process(new AtualizarSaldoContaCorrenteProcessor())
                		.marshal().json(JsonLibrary.Jackson, HttpEntity.class)
                		.to(ExchangePattern.InOnly, urlContaCorrente)
                	.otherwise()
                		.throwException(new SaldoIndisponivelException("Seu saldo eh menor que o minimo para esta operacao", HttpStatus.BAD_GATEWAY))
                .end();
        
        
        from("direct:parceiroSolicitaPagamento")
        .to(ExchangePattern.InOnly, toParceiroSolicitaPagamento());        
        		
    }

	private String fromPagamentoQueue() {
		StringBuffer sb = new StringBuffer();
		sb.append(RouterConstants.RABBIT_COMPONENT);
		sb.append(RouterConstants.EXCHANGE_PAGAMENTO);
		sb.append("?" + RouterConstants.QUEUE);
		sb.append("=" + RouterConstants.QUEUE_SOLICITAR_PAGAMENTO);
		sb.append("&" + RouterConstants.AUTO_DELETE_FALSE);
		return sb.toString();
	}

	
	private String toParceiroSolicitaPagamento() {
		StringBuffer sb = new StringBuffer();
		sb.append(RouterConstants.RABBIT_COMPONENT);
		sb.append(RouterConstants.EXCHANGE_PAGAMENTO);
		sb.append("?" + RouterConstants.QUEUE);
		sb.append("=" + RouterConstants.QUEUE_SOLICITAR_PAGAMENTO);
		sb.append("&" + RouterConstants.AUTO_DELETE_FALSE);
		return sb.toString();
	}
	
}
