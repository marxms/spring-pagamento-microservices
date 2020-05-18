package com.marx.instrutor.cliente.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marx.instrutor.cliente.repository.ClienteRepositoryImpl;
import com.marx.instrutor.data.Cliente;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepositoryImpl repository;
	
	
	@Override
	public List<Cliente> obterClientePorCpf(String cpf) {
		return repository.obterClientePorCpf(cpf);
	}

	@Override
	public Cliente incluirCliente(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public Cliente editarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exluirClientePorCpf(String cpf) {
		// TODO Auto-generated method stub
		
	}

}
