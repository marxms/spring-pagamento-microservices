package com.marx.instrutor.representation;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = ClienteRepresentation.class)
public class ContaCorrenteRepresentation {
	private Long id;
	
	private String numeroConta;

	private String digito;

	private ClienteRepresentation titular;
	
	private BigDecimal saldo;
	
	private BigDecimal saldoEspecial;
	
	private String flagAtiva;

	private List<PagamentoRepresentation> pagamento;
}
