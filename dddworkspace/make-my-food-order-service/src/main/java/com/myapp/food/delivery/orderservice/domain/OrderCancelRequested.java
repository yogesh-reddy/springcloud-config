package com.myapp.food.delivery.orderservice.domain;

import com.myapp.food.delivery.orderservice.api.events.OrderState;

import io.eventuate.tram.events.common.DomainEvent;

public class OrderCancelRequested implements DomainEvent {
  private OrderState state;

  public OrderCancelRequested(OrderState state) {

    this.state = state;
  }

  public OrderState getState() {
    return state;
  }
}
