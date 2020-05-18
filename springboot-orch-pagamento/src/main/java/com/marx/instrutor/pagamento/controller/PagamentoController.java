package com.marx.instrutor.pagamento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marx.instrutor.pagamento.service.PagamentoServiceImpl;
import com.marx.instrutor.representation.SolicitarPagamentoRepresentation;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/parceiro/pagamento")
@AllArgsConstructor
public class PagamentoController {
	
	private PagamentoServiceImpl pagamentoService;
	
	@PostMapping
	public ResponseEntity<Void> efetuarPagamento(@RequestBody SolicitarPagamentoRepresentation solicitarPagamentoRepresentation) {
		pagamentoService.parceiroSolicitaPagamento(solicitarPagamentoRepresentation);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
