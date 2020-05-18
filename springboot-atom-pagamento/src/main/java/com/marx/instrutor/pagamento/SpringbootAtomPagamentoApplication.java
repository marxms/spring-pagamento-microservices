package com.marx.instrutor.pagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.marx.instrutor.data"})  // scan JPA entities
public class SpringbootAtomPagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAtomPagamentoApplication.class, args);
	}

}
