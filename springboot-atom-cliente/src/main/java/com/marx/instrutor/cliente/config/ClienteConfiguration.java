package com.marx.instrutor.cliente.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfiguration {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
