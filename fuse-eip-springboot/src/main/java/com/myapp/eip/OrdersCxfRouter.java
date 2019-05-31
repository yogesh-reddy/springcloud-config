package com.myapp.eip;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class OrdersCxfRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("cxfrs:http://localhost:8080?resourceClasses=com.myapp.eip.OrdersService&bindingStyle=SimpleConsumer&providers=#jsonProvider")
		.toD("direct:${header.operationName}");
		
		
		from("direct:createOrder")
		.bean("ordersServiceImpl","createOrder");
		
		from("direct:getOrder")
		.bean("ordersServiceImpl","getOrder(${header.orderId})");
		
		from("direct:deleteOrder")
		.bean("ordersServiceImpl","deleteOrder(${header.orderId})");
		
	}

}
