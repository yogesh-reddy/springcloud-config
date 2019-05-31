package com.myapp.eip;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@RunWith(CamelSpringBootRunner.class)
@SpringBootTest

//@MockEndpoints
public class CamelContextXmlTest  {

	// Mock endpoints used to consume messages from the output endpoints and then perform assertions
	@EndpointInject(uri = "mock:accounting")
	protected MockEndpoint outputEndpoint;
	
//	@Autowired
//	private CamelContext context;
	
	@Autowired
	private ProducerTemplate template;
	
	@Test
	public void testCamelRoute() throws Exception {

			outputEndpoint.expectedMessageCount(0);
		outputEndpoint.assertIsSatisfied();
			
	}


	@Test
	public void testGetOrderBasedOnTheId() throws Exception {
		
		//OrdersServiceImpl service=context.getRegistry().lookupByNameAndType("ordersServiceImpl", OrdersServiceImpl.class);

	String response=	template.requestBodyAndHeader("restlet:http://localhost:8080/orders/1?restletMethod=GET", null, 
				"accept","application/json",String.class);
		System.out.println("Response :{} "+response);
		
			
	}
	
	

	@Test
	public void testCreateOrder() throws Exception {
	
		String json="{\"orderId\" : \"100\" , "
                + "\"orderName\" : \"Order100\", "
                + "\"orderDate\" : \"28-05-2019\"}";

		Map<String,String> headers= new HashMap<>();
		headers.put("Content-Type","application/json");
		
Integer response=	template.requestBodyAndHeader("restlet:http://localhost:8080/orders?restletMethod=POST",json, 
				"accept","application/json",Integer.class);
		assertNotNull(response);
		
			
	}



}
