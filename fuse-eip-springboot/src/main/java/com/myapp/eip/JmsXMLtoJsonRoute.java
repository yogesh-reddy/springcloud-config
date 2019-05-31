package com.myapp.eip;

import java.time.LocalDate;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.stereotype.Component;

@Component
public class JmsXMLtoJsonRoute  extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		JaxbDataFormat xmlDataFormat= new JaxbDataFormat();
		JAXBContext context=JAXBContext.newInstance(Orders.class);
		xmlDataFormat.setContext(context);
		
		JacksonDataFormat json= new JacksonDataFormat(Orders.class);
		
		from("file:ordersdata").doTry().unmarshal(xmlDataFormat).process((Exchange e)->{
			Orders orders=e.getIn().getBody(Orders.class);
			orders.setOrderId(1);
			orders.setOrderDate(LocalDate.now());
			orders.setOrderName("Order1");
			e.getIn().setBody(orders);
			
		}).marshal(json).to("jms:queue:myneworders").doCatch(Exception.class)
		.process((e)->{
		Exception cause=e.getProperty(Exchange.EXCEPTION_CAUGHT,Exception.class);
		System.out.println(cause);
		});
		
	}
	
	

}
