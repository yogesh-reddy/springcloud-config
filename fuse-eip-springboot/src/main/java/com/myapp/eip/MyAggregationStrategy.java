package com.myapp.eip;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.stereotype.Component;

@Component
public class MyAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		// TODO Auto-generated method stub
		
		if(oldExchange ==null) {
			return newExchange;
		}
		Orders body=newExchange.getIn().getBody(Orders.class);
		Orders existing=oldExchange.getIn().getBody(Orders.class);
		oldExchange.getIn().setBody(existing+"+"+body);
		return oldExchange;
	}

}
