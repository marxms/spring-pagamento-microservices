package com.marx.instrutor.pagamento.service;

import org.apache.camel.ProducerTemplate;

import com.marx.instrutor.pagamento.camel.CamelContextWrapper;
import com.marx.instrutor.representation.SolicitacaoPagamentoResponse;
import com.marx.instrutor.representation.SolicitarPagamentoRepresentation;

public class PagamentoServiceImpl {

	   private final ProducerTemplate template;

	    public PagamentoServiceImpl(CamelContextWrapper wrapper) {
	        this.template = wrapper.createProducerTemplate();
	    }
	    
	public SolicitacaoPagamentoResponse parceiroSolicitaPagamento(SolicitarPagamentoRepresentation solicitarPagamentoRepresentation) {
		return template.requestBody("direct:parceiroSolicitaPagamento", solicitarPagamentoRepresentation,
				SolicitacaoPagamentoResponse.class);
		
	}
}
