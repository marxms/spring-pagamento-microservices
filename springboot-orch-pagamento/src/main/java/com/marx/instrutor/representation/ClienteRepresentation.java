package com.marx.instrutor.representation;

import java.util.Date;
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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class ClienteRepresentation {

	private Long id;
	
	private String nomeCompleto;
	
	private GeneroEnum tpSexo;
	
	private String cpf;
	
	private Date dtNascimento;
	
	private List<ContaCorrenteRepresentation> contas;
	
}
