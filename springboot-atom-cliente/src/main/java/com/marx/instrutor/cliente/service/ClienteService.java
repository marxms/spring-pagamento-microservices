package com.marx.instrutor.cliente.service;

import java.util.List;

import com.marx.instrutor.data.Cliente;

public interface ClienteService {

	public List<Cliente> obterClientePorCpf(String cpf);
	
	public Cliente incluirCliente(Cliente cliente);
	
	public Cliente editarCliente(Cliente cliente);
	
	public void exluirClientePorCpf(String cpf);
	
}
