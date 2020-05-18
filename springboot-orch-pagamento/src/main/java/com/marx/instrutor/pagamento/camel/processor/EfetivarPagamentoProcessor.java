package com.marx.instrutor.pagamento.camel.processor;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.http.HttpMethods;

import com.marx.instrutor.representation.ContaCorrenteRepresentation;
import com.marx.instrutor.representation.PagamentoRepresentation;
import com.marx.instrutor.representation.SolicitarPagamentoRepresentation;

public class EfetivarPagamentoProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		SolicitarPagamentoRepresentation solicitacaoPagamento = exchange.getProperty("initialPayload", SolicitarPagamentoRepresentation.class);
		ContaCorrenteRepresentation contaRepresentation = exchange.getIn().getBody(ContaCorrenteRepresentation.class);
		exchange.setProperty("contaCorrentePayload", contaRepresentation);
		exchange.setProperty("titularPayload", contaRepresentation.getTitular());
		contaRepresentation.setTitular(null);
		PagamentoRepresentation efetivarPagamentoRepresentation = new PagamentoRepresentation();
		efetivarPagamentoRepresentation.setContaCorrente(contaRepresentation);
		efetivarPagamentoRepresentation.setDtPagamento(new Date());
		efetivarPagamentoRepresentation.setValorPagamento(solicitacaoPagamento.getValorPagamento());
		exchange.getMessage().setBody(efetivarPagamentoRepresentation, PagamentoRepresentation.class);
		exchange.getMessage().removeHeader(Exchange.HTTP_PATH);
		exchange.getMessage().setHeader(Exchange.HTTP_METHOD, HttpMethods.POST);
	}

}
