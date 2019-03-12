package com.myapp.food.delivery.orderservice.domain;


import io.eventuate.tram.events.common.DomainEvent;

public class OrderRevisionRejected implements DomainEvent {

  public OrderRevisionRejected(OrderRevision orderRevision) {
    throw new UnsupportedOperationException();
  }

}
