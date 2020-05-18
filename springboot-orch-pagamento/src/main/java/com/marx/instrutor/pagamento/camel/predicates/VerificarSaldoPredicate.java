package com.marx.instrutor.pagamento.camel.predicates;

import java.math.BigDecimal;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;

import com.marx.instrutor.representation.ContaCorrenteRepresentation;
import com.marx.instrutor.representation.SolicitarPagamentoRepresentation;

public class VerificarSaldoPredicate implements Predicate{

	@Override
	public boolean matches(Exchange exchange) {
		SolicitarPagamentoRepresentation solicitacaoPagamento = exchange.getProperty("initialPayload", SolicitarPagamentoRepresentation.class);
		BigDecimal saldoContaCorrente = exchange.getIn().getBody(ContaCorrenteRepresentation.class).getSaldo();
		BigDecimal valorPagamento = solicitacaoPagamento.getValorPagamento();
		if(saldoContaCorrente.subtract(valorPagamento).compareTo(BigDecimal.ZERO) >= 0) {
			return true;
		}
		return false;
	}

}
