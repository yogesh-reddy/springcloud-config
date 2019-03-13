package com.myapp.food.delivery.accountingservice.messaging;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.food.delivery.accountingservice.domain.AccountingService;
import com.myapp.food.delivery.consumerservice.domain.ConsumerCreated;


public class AccountingEventConsumer {

  @Autowired
  private AccountingService accountingService;

  public DomainEventHandlers domainEventHandlers() {
    return DomainEventHandlersBuilder
            .forAggregateType("com.myapp.food.delivery.consumerservice.domain.Consumer")
            .onEvent(ConsumerCreated.class, this::createAccount) 
            .build();
  }

  private void createAccount(DomainEventEnvelope<ConsumerCreated> dee) {
    accountingService.create(dee.getAggregateId());
  }


}
