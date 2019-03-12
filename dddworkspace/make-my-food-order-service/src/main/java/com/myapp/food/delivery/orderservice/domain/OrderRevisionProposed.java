package com.myapp.food.delivery.orderservice.domain;

import com.myapp.food.delivery.common.Money;
import com.myapp.food.delivery.orderservice.api.events.OrderDomainEvent;

// import io.eventuate.tram.events.common.DomainEvent;

import io.eventuate.tram.events.common.DomainEvent;

public class OrderRevisionProposed implements OrderDomainEvent {


  private final OrderRevision orderRevision;
  private final Money currentOrderTotal;
  private final Money newOrderTotal;

  public OrderRevisionProposed(OrderRevision orderRevision, Money currentOrderTotal, Money newOrderTotal) {
    this.orderRevision = orderRevision;
    this.currentOrderTotal = currentOrderTotal;
    this.newOrderTotal = newOrderTotal;
  }

  public OrderRevision getOrderRevision() {
    return orderRevision;
  }

  public Money getCurrentOrderTotal() {
    return currentOrderTotal;
  }

  public Money getNewOrderTotal() {
    return newOrderTotal;
  }
}
