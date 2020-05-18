package com.marx.instrutor.pagamento.service;

import java.util.List;

import com.marx.instrutor.data.Pagamento;

public interface PagamentoService {

	
	public Pagamento efetuarPagamento(Pagamento pagamento);
	
	public List<Pagamento> consultarPagamentoPorCpf(Pagamento pagamento);
	
	
}
