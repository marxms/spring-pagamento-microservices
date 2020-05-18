package com.marx.instrutor.contacorrente.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marx.instrutor.contacorrente.service.ContaCorrenteService;
import com.marx.instrutor.data.ContaCorrente;
import com.marx.instrutor.representation.ContaCorrenteRepresentation;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/contaCorrente")
@Api(tags = "ContaCorrenteAPI")
@AllArgsConstructor
public class ContaCorrenteController {

	private ContaCorrenteService contaCorrenteService;
	private ModelMapper modelMapper;
	
	@GetMapping("/{numeroContaCorrente}")
	public ResponseEntity<ContaCorrenteRepresentation> obterContaCorrentePorNumeroConta(@PathVariable String numeroContaCorrente) {
		return new ResponseEntity<ContaCorrenteRepresentation>(modelMapper
				.map(contaCorrenteService.obterContaCorrente(numeroContaCorrente), ContaCorrenteRepresentation.class),
				HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ContaCorrenteRepresentation> inserirContaCorrente(@RequestBody ContaCorrenteRepresentation contaCorrenteRepresentation) {
		return new ResponseEntity<ContaCorrenteRepresentation>(modelMapper.map(
				contaCorrenteService
						.incluirContaCorrente(modelMapper.map(contaCorrenteRepresentation, ContaCorrente.class)),
				ContaCorrenteRepresentation.class), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ContaCorrenteRepresentation> atualizarContaCorrente(@RequestBody ContaCorrenteRepresentation contaCorrenteRepresentation) {
		return new ResponseEntity<ContaCorrenteRepresentation>(modelMapper.map(
				contaCorrenteService
						.editarContaCorrente(modelMapper.map(contaCorrenteRepresentation, ContaCorrente.class)),
				ContaCorrenteRepresentation.class), HttpStatus.OK);
	}
	
}
