package com.marx.instrutor.representation;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class SolicitarPagamentoRepresentation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3188265208394685345L;

	private String numeroConta;
	
	private BigDecimal valorPagamento;
	
}
