package com.myapp.eip;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class OrderProcessorBean {
	
	private Map<String, Orders> map=new HashMap<>();
	public OrderProcessorBean() {
	
		
		map.put("order1",new Orders(11, "MyOrder1", LocalDate.now()));
		map.put("order2",new Orders(12, "MyOrder2", LocalDate.now()));
		map.put("order3",new Orders(12, "MyOrder3", LocalDate.now()));
		
	}
	
	public Orders getOrder(String key) {
	if(!map.containsKey(key)) {
		throw new IllegalArgumentException("No Order Found");
	}
	return map.get(key);
	}
	

}
