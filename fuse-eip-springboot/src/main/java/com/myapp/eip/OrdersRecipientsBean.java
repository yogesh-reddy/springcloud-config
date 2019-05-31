package com.myapp.eip;

import org.apache.camel.RecipientList;
import org.apache.camel.language.XPath;
import org.springframework.stereotype.Component;

@Component
public class OrdersRecipientsBean {
	
	@RecipientList
	public String[] recipients(@XPath("/order/@customer")String customer) {
		
		if(customer.equals("PRIME")) {
			return new String[] {"jms:queue:accounting","jms:queue:production"};
		}
		else {
			return new String[] {"jms:queue:accounting"};
		}
		
	}

}
