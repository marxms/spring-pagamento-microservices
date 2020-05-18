package com.marx.instrutor.pagamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marx.instrutor.data.Pagamento;
import com.marx.instrutor.pagamento.config.repository.PagamentoRepositoryImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PagamentoServiceImpl implements PagamentoService{

	private PagamentoRepositoryImpl repository;
	
	@Override
	public Pagamento efetuarPagamento(Pagamento pagamento) {
		return repository.save(pagamento);
	}

	@Override
	public List<Pagamento> consultarPagamentoPorCpf(Pagamento pagamento) {
		return null;
	}

}
