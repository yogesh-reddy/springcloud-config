package com.myapp.food.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FoodDeliveryRestaurantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryRestaurantServiceApplication.class, args);
	}

}
