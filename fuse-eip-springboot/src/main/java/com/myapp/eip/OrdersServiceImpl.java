package com.myapp.eip;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class OrdersServiceImpl implements OrdersService {
	
	private Map<Integer, Orders> map=new HashMap<>();
	
	public OrdersServiceImpl() {
		// TODO Auto-generated constructor stub
		
		map.put(1, new Orders(1, "Order1", LocalDate.now()));
		map.put(2, new Orders(2, "Order2", LocalDate.now()));
		map.put(3, new Orders(3, "Order3", LocalDate.now()));
	}

	@Override
	public Orders getOrder(int orderid) {
		// TODO Auto-generated method stub
		return map.get(orderid);
	}

	@Override
	public Integer createOrder(Orders orders) {
		// TODO Auto-generated method stub
		
		map.putIfAbsent(orders.getOrderId(), orders);
		return orders.getOrderId();
	}

	@Override
	public Orders deleteOrder(int orderid) {
		// TODO Auto-generated method stub
		return map.remove(orderid);
	}

}
