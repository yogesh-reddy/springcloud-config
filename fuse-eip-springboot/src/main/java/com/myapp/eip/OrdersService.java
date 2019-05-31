package com.myapp.eip;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/orders/")
@Produces(value = "application/xml,application/json")
@Consumes(value = "application/xml,application/json")
public interface OrdersService {
	
	
	// http://localhost:8080/orders/1
	
	@GET
	@Path("/{orderid}")
	Orders getOrder(@PathParam("orderid")int orderid);
	
	
	// http://localhost:8080/orders
	@POST
	
	Integer createOrder(Orders orders);
	
	
	// http://localhost:8080/orders/1

	@DELETE
	@Path("/{orderid}")
	Orders deleteOrder(@PathParam("orderid")int orderid);

}
