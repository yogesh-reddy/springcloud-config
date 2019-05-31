/**
 *  Copyright 2005-2018 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package com.myapp;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * A spring-boot application that includes a Camel route builder to setup the Camel routes
 */
@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
public class Application implements CommandLineRunner {
	
	@Bean
	public JmsComponent jmsComponent() {
		JmsComponent component=new JmsComponent();
		component.setConnectionFactory(new ActiveMQConnectionFactory("vm://localhost:61616"));
		return component;
	}
	
	@Bean
	public JacksonJsonProvider jsonProvider() {
		return new JacksonJsonProvider();
	}
	
	@Autowired
	private CamelContext context;

    // must have a main method spring-boot can run
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		ProducerTemplate template=context.createProducerTemplate();
//		template.sendBody("direct:in1", new Object[]{"Hello1","Hello2","Hello3","Hello4"});
//		template.sendBody("direct:in2","order1");
//		template.sendBody("direct:in2","order2");
//		template.sendBody("direct:in2","order3");
//		
//		template.sendBody("direct:dynamic","route1");
//		template.sendBody("direct:dynamic","route2");
//		template.sendBody("direct:dynamic","route3");
		
		
	}

}
