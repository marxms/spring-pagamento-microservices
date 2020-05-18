package com.marx.instrutor.contacorrente.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContaCorrenteConfiguration {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
