package com.marx.instrutor.pagamento.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.http.HttpMethods;

import com.marx.instrutor.representation.ClienteRepresentation;
import com.marx.instrutor.representation.ContaCorrenteRepresentation;
import com.marx.instrutor.representation.SolicitarPagamentoRepresentation;

public class AtualizarSaldoContaCorrenteProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		SolicitarPagamentoRepresentation solicitacaoPagamento = exchange.getProperty("initialPayload", SolicitarPagamentoRepresentation.class);
		ContaCorrenteRepresentation contaRepresentation = exchange.getProperty("contaCorrentePayload", ContaCorrenteRepresentation.class);
		ClienteRepresentation titular = exchange.getProperty("titularPayload", ClienteRepresentation.class);
		contaRepresentation.setSaldo(contaRepresentation.getSaldo().subtract(solicitacaoPagamento.getValorPagamento()));
		ClienteRepresentation cliente = new ClienteRepresentation();
		cliente.setId(titular.getId());
		contaRepresentation.setTitular(cliente);
		contaRepresentation.setPagamento(null);
		exchange.getMessage().setHeader(Exchange.HTTP_METHOD, HttpMethods.PUT);
		exchange.getMessage().setBody(contaRepresentation);
	}

}
