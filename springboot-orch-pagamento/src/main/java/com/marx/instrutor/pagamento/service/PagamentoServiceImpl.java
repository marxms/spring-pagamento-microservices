package com.marx.instrutor.pagamento.service;

import org.apache.camel.ProducerTemplate;

import com.marx.instrutor.pagamento.camel.CamelContextWrapper;
import com.marx.instrutor.representation.SolicitarPagamentoRepresentation;

public class PagamentoServiceImpl {

	   private final ProducerTemplate template;

	    public PagamentoServiceImpl(CamelContextWrapper wrapper) {
	        this.template = wrapper.createProducerTemplate();
	    }
	    
	public void parceiroSolicitaPagamento(SolicitarPagamentoRepresentation solicitarPagamentoRepresentation) {
		template.requestBody("direct:parceiroSolicitaPagamento", solicitarPagamentoRepresentation,
				SolicitarPagamentoRepresentation.class);
		
	}
}
