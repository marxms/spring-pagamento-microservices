package com.marx.instrutor.pagamento.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.marx.instrutor.representation.SolicitacaoPagamentoResponse;

public class NotificarPagamentoProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		SolicitacaoPagamentoResponse response = new SolicitacaoPagamentoResponse();
    	response.setCode(200);
    	response.setMessage("Pagamento enviado");
    	exchange.getMessage().setBody(response, SolicitacaoPagamentoResponse.class);
	}
}
