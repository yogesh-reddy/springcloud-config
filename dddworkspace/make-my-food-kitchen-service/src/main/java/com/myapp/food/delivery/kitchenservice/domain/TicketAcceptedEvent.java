package com.myapp.food.delivery.kitchenservice.domain;

import java.time.LocalDateTime;

public class TicketAcceptedEvent implements TicketDomainEvent {
  public TicketAcceptedEvent(LocalDateTime readyBy) {

  }
}
