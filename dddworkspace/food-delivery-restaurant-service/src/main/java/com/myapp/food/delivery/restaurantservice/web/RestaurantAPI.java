package com.myapp.food.delivery.restaurantservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.food.delivery.restaurantservice.domain.Restaurant;
import com.myapp.food.delivery.restaurantservice.repository.RestaurantRepository;

@RestController
public class RestaurantAPI {
	
	
	@Autowired
	private RestaurantRepository repository;
	
	@PostMapping("/restaurants")
	public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant){
	 
		repository.save(restaurant);
	 
	 return new ResponseEntity<Restaurant>(restaurant, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/restaurants/{id}")
	public ResponseEntity<Restaurant> fetch(@PathVariable("id")long id){
		
	return  new ResponseEntity<Restaurant>(repository.findById(id).get(),HttpStatus.OK);
		
	}
	

}
