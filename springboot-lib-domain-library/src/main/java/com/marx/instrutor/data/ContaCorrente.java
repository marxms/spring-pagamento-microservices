package com.marx.instrutor.data;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TB_CONTACORRENTE")
@DynamicUpdate
public class ContaCorrente {
	
	@Id
	@GenericGenerator(name="contaIncrement" , strategy="increment")
	@GeneratedValue(generator="contaIncrement")
	private Long id;
	
	@Column
	private String numeroConta;
	
	@Column
	private String digito;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_titular")
	private Cliente titular;
	
	@Column
	private BigDecimal saldo;
	
	@Column
	private BigDecimal saldoEspecial;
	
	@Column
	private String flagAtiva;
	
	@OneToMany(mappedBy = "contaCorrente")
	private List<Pagamento> pagamento;
	
}
