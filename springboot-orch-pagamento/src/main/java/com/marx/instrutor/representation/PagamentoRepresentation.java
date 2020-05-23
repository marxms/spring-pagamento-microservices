package com.marx.instrutor.representation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = ContaCorrenteRepresentation.class)
public class PagamentoRepresentation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4610945248635771306L;

	private Long id;
	
	private BigDecimal valorPagamento;
	
	private Date dtPagamento;
	
	private ContaCorrenteRepresentation contaCorrente;
}
