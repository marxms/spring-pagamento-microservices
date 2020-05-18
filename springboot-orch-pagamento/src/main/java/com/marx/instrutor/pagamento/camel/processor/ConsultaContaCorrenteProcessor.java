package com.marx.instrutor.pagamento.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.http.HttpMethods;

import com.marx.instrutor.representation.SolicitarPagamentoRepresentation;

public class ConsultaContaCorrenteProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		SolicitarPagamentoRepresentation solicitarPagamentoRepresentation = exchange.getIn().getBody(SolicitarPagamentoRepresentation.class);
		exchange.getMessage().setHeader(Exchange.HTTP_METHOD, HttpMethods.GET);
		exchange.getMessage().setHeader(Exchange.HTTP_PATH, solicitarPagamentoRepresentation.getNumeroConta());
	}

}
