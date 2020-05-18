package com.marx.instrutor.data;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.marx.instrutor.commons.GeneroEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TB_CLIENTE")
public class Cliente {

	@Id
	@GenericGenerator(name="clienteIncrement" , strategy="increment")
	@GeneratedValue(generator="clienteIncrement")	
	private Long id;
	
	@Column
	private String nomeCompleto;
	
	@Enumerated(EnumType.STRING)
	@Column
	private GeneroEnum tpSexo;
	
	@Column
	private String cpf;
	
	@Column
	private Date dtNascimento;
	
	@OneToMany(mappedBy = "titular", cascade = CascadeType.MERGE)
	private List<ContaCorrente> contas;
	
}