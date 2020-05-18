package com.marx.instrutor.pagamento.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PagamentoConfiguration {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
