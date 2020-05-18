package com.marx.instrutor.contacorrente.service;

import com.marx.instrutor.data.ContaCorrente;

public interface ContaCorrenteService {
	
	public ContaCorrente obterContaCorrente(String numeroContaCorrente);
	
	public ContaCorrente incluirContaCorrente(ContaCorrente contaCorrente);
	
	public ContaCorrente editarContaCorrente(ContaCorrente contaCorrente);
	
	public void excluirContaCorrentePorNumeroConta(String numeroContaCorrente);
}
