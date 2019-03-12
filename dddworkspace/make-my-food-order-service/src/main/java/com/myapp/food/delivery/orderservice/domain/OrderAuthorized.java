package com.myapp.food.delivery.orderservice.domain;

import io.eventuate.tram.events.common.DomainEvent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.myapp.food.delivery.orderservice.api.events.OrderDomainEvent;

public class OrderAuthorized implements OrderDomainEvent {

  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

}
