package com.marx.instrutor.pagamento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marx.instrutor.pagamento.service.PagamentoServiceImpl;
import com.marx.instrutor.representation.SolicitacaoPagamentoResponse;
import com.marx.instrutor.representation.SolicitarPagamentoRepresentation;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/parceiro/pagamento")
@AllArgsConstructor
public class PagamentoController {
	
	private PagamentoServiceImpl pagamentoService;
	
	@PostMapping
	public ResponseEntity<SolicitacaoPagamentoResponse> efetuarPagamento(@RequestBody SolicitarPagamentoRepresentation solicitarPagamentoRepresentation) {
		SolicitacaoPagamentoResponse response = pagamentoService.parceiroSolicitaPagamento(solicitarPagamentoRepresentation);
		return new ResponseEntity<SolicitacaoPagamentoResponse>(response, HttpStatus.OK);
	}

}
