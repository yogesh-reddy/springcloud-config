package com.myapp.eip;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.springframework.stereotype.Component;

@Component
public class RouterDecisionBean {
	
	public String route(String body, @Header(Exchange.SLIP_ENDPOINT) String previousRoute) {
		if (previousRoute == null) {
			return "direct://route3";
			// check the body content and decide route
		} else if (body.toString().equals("started in route 3")) {
			return "direct://route2";
			// check the body content and decide route
		} else if (body.toString().equals("started in route 3  moved to route 2")) {
			return "direct://route1";
		} else {
			return null;
		}
	}
	

}
