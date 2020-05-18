package com.marx.instrutor.contacorrente.service;

import org.springframework.stereotype.Service;

import com.marx.instrutor.contacorrente.repository.ContaCorrenteRepositoryImpl;
import com.marx.instrutor.data.ContaCorrente;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

	private ContaCorrenteRepositoryImpl repository;
	
	@Override
	public ContaCorrente obterContaCorrente(String numeroContaCorrente) {
		return repository.obterContaCorrentePorNumero(numeroContaCorrente);
	}

	@Override
	public ContaCorrente incluirContaCorrente(ContaCorrente contaCorrente) {
		return repository.save(contaCorrente);
	}

	@Override
	public ContaCorrente editarContaCorrente(ContaCorrente contaCorrente) {
		return repository.update(contaCorrente);
	}

	@Override
	public void excluirContaCorrentePorNumeroConta(String numeroContaCorrente) {
		// TODO Auto-generated method stub
		
	}


	
}
