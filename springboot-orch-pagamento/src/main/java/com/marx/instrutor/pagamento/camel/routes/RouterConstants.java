package com.marx.instrutor.pagamento.camel.routes;

public class RouterConstants {

	public static final String SOLICITAR_PAGAMENTO_FLOW = "direct:solicitarPagamentoFlow";
	public static final String RABBIT_COMPONENT = "rabbitmq:";
	public static final String QUEUE = "queue";
	public static final String ROUTING_KEY = "routingKey";
	public static final String AUTO_DELETE_FALSE = "autoDelete=false";
	public static final String HEADER_ROUTING_KEY = "rabbitmq.ROUTING_KEY";
	// EXCHANGE
    public static final String EXCHANGE_PAGAMENTO = "pagamentoExchange";
	
	
	// QUEUE
    public static final String QUEUE_SOLICITAR_PAGAMENTO = "queue.solicitarPagamento";
    
    
    //ROUNTING KEYS
    public static final String ROUTINGKEY_SOLICITAR_PAGAMENTO = "routingkey.solicitarPagamento	";
    

}
