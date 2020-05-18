package com.marx.instrutor.pagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

@SpringBootApplication(exclude = {RabbitAutoConfiguration.class})
public class SpringbootOrchPagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootOrchPagamentoApplication.class, args);
	}

}
