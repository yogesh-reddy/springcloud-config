package com.myapp.food.delivery.kitchenservice.messagehandlers;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.food.delivery.kitchenservice.domain.KitchenService;
import com.myapp.food.delivery.restaurantservice.events.RestaurantCreated;
import com.myapp.food.delivery.restaurantservice.events.RestaurantMenu;
import com.myapp.food.delivery.restaurantservice.events.RestaurantMenuRevised;

public class KitchenServiceEventConsumer {

	@Autowired
	private KitchenService kitchenService;

	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("com.myapp.food.delivery.restaurantservice.domain.Restaurant")
				.onEvent(RestaurantCreated.class, this::createMenu)
				.onEvent(RestaurantMenuRevised.class, this::reviseMenu).build();
	}

	private void createMenu(DomainEventEnvelope<RestaurantCreated> de) {
		String restaurantIds = de.getAggregateId();
		long id = Long.parseLong(restaurantIds);
		RestaurantMenu menu = de.getEvent().getMenu();
		kitchenService.createMenu(id, menu);
	}

	public void reviseMenu(DomainEventEnvelope<RestaurantMenuRevised> de) {

		long id = Long.parseLong(de.getAggregateId());
		RestaurantMenu revisedMenu = de.getEvent().getRevisedMenu();
		kitchenService.reviseMenu(id, revisedMenu);
	}

}
