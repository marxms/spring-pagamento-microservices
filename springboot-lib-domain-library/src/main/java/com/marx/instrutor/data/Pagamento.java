package com.marx.instrutor.data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_PAGAMENTO")
public class Pagamento {

	@Id
	@GenericGenerator(name = "pagamentoIncrement", strategy = "increment")
	@GeneratedValue(generator = "pagamentoIncrement")
	private Long id;

	@Column
	private BigDecimal valorPagamento;

	@Column
	private Date dtPagamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contaCorrente")
	private ContaCorrente contaCorrente;

}
