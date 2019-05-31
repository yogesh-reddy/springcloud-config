package com.myapp.eip;

import java.util.concurrent.ExecutorService;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.ThreadPoolBuilder;
import org.springframework.stereotype.Component;

@Component
public class ParallelRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		ExecutorService executorService= new ThreadPoolBuilder(getContext()).poolSize(5)
				.maxQueueSize(100).build("CustomThreadPool");
		
		from("direct:in1")
		.log("Recieved ${body}: ${threadName}")
		.threads().executorService(executorService).log("Processing ${body}: ${threadName}")
		.transform(simple("${threadName}")).to("mock:out");

		
		
		from("direct:dynamic").split().tokenize("\n").dynamicRouter(method(RouterDecisionBean.class, "route"));

		from("direct:route1").process(new Processor() {
			public void process(Exchange exchange) {
				String body = exchange.getIn().getBody().toString();
				body = body + " in route 1";
				System.out.println(body);
				exchange.getIn().setBody(body);
			}
		});

		from("direct:route2").process(new Processor() {
			public void process(Exchange exchange) {
				String body = exchange.getIn().getBody().toString();
				body = body + " in route 2";
				System.out.println(body);
				exchange.getIn().setBody(body);
			}
		});

		from("direct:route3").process(new Processor() {
			public void process(Exchange exchange) {
				String body = exchange.getIn().getBody().toString();
				body = body + " in route 3";
				exchange.getIn().setBody(body);
				System.out.println(body);
			}
		});
		
	}

}
