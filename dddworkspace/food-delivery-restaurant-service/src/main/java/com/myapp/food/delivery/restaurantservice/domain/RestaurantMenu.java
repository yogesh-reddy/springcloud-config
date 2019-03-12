package com.myapp.food.delivery.restaurantservice.domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;



@Embeddable
@Access(AccessType.FIELD)
public class RestaurantMenu {
	
	@ElementCollection
	private List<MenuItem> menuItems;

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	
	
	

}
