package com.marx.instrutor.cliente;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.marx.instrutor.data"})  // scan JPA entities
public class SpringbootAtomClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAtomClienteApplication.class, args);
	}
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
