package com.myapp.food.delivery.kitchenservice.domain;


import com.myapp.food.delivery.kitchenservice.api.TicketDetails;

public class TicketCreatedEvent implements TicketDomainEvent {
  public TicketCreatedEvent(Long id, TicketDetails details) {

  }
}
