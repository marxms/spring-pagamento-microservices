package com.marx.instrutor.cliente.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marx.instrutor.cliente.service.ClienteService;
import com.marx.instrutor.data.Cliente;
import com.marx.instrutor.representation.ClienteRepresentation;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/cliente")
@Api(tags = "clienteAPI")
@AllArgsConstructor
public class ClienteController {

	private ClienteService clienteService;
	private ModelMapper modelMapper;
	
	@GetMapping(path = "/{cpf}")
	public ResponseEntity<List<ClienteRepresentation>> obterClientePorCpf(@PathVariable String cpf) {
		List<ClienteRepresentation> clientesResponse = new ArrayList<ClienteRepresentation>(0);
		clienteService.obterClientePorCpf(cpf).forEach(cliente -> {
			clientesResponse.add(modelMapper.map(cliente, ClienteRepresentation.class));
		});
		return new ResponseEntity<List<ClienteRepresentation>>(clientesResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ClienteRepresentation> inserirCliente(@RequestBody ClienteRepresentation clienteRepresentation) {
		return new ResponseEntity<ClienteRepresentation>(modelMapper.map(clienteService.incluirCliente(modelMapper.map(clienteRepresentation, Cliente.class)), ClienteRepresentation.class), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ClienteRepresentation> atualizarCliente(@RequestBody ClienteRepresentation clienteRepresentation) {
		return null;
	}
	
	@DeleteMapping(path = "/{cpf}")
	public ResponseEntity<Void> excluirCliente(@PathVariable String cpf) {
		return null;
	}
}
