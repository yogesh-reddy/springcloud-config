package com.myapp.food.delivery.restaurantservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.food.delivery.restaurantservice.domain.Restaurant;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}
