package com.marx.instrutor.pagamento.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marx.instrutor.data.Pagamento;
import com.marx.instrutor.pagamento.service.PagamentoService;
import com.marx.instrutor.representation.PagamentoRepresentation;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/pagamento")
@Api(tags = "PagamentoAPI")
@AllArgsConstructor
public class PagamentoController {

	private PagamentoService pagamentoService;
	private ModelMapper modelMapper;
	@PostMapping
	public ResponseEntity<PagamentoRepresentation> efetuarPagamento(@RequestBody PagamentoRepresentation pagamentoRepresentation) {
		return new ResponseEntity<PagamentoRepresentation>(modelMapper.map(
				pagamentoService.efetuarPagamento(modelMapper.map(pagamentoRepresentation, Pagamento.class)),
				PagamentoRepresentation.class), HttpStatus.OK);
	}
}
