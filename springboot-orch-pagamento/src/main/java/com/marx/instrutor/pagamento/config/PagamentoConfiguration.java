package com.marx.instrutor.pagamento.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.marx.instrutor.pagamento.camel.CamelContextWrapper;
import com.marx.instrutor.pagamento.service.PagamentoServiceImpl;
import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class PagamentoConfiguration {

	@Value("${app.rabbitmq.username}")
	private String username;
	@Value("${app.rabbitmq.password}")
	private String password;
	@Value("${app.rabbitmq.port}")
	private Integer port;
	@Value("${app.rabbitmq.host}")
	private String host;
    
	@Bean
    public ConnectionFactory rabbitConnectionFactory() {
    	ConnectionFactory conn = new ConnectionFactory();
    	conn.setHost(host);
    	conn.setPort(port);
    	conn.setUsername(username);
    	conn.setPassword(password);
    	conn.setVirtualHost("/");
        return conn;
    }
	
    @Bean
    public CamelContextWrapper camelContextWrapper(RouteBuilder... routes) throws Exception {
        return new CamelContextWrapper(rabbitConnectionFactory(), routes);
    }
    
    @Bean
    public PagamentoServiceImpl suporteNegocioService(CamelContextWrapper camelContextWrapper) {
        return new PagamentoServiceImpl(camelContextWrapper);
    }
}
