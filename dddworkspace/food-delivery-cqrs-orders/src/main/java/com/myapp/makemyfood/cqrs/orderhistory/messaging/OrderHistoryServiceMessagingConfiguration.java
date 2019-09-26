package com.myapp.makemyfood.cqrs.orderhistory.messaging;

import io.eventuate.tram.consumer.kafka.DuplicateMessageDetector;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.messaging.consumer.MessageConsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.myapp.makemyfood.common.CommonConfiguration;
import com.myapp.makemyfood.cqrs.orderhistory.OrderHistoryDao;
import com.myapp.makemyfood.cqrs.orderhistory.dynamodb.OrderHistoryDynamoDBConfiguration;

@Configuration
@Import(CommonConfiguration.class)
public class OrderHistoryServiceMessagingConfiguration {

  @Bean
  public OrderHistoryEventHandlers orderHistoryEventHandlers(OrderHistoryDao orderHistoryDao) {
    return new OrderHistoryEventHandlers(orderHistoryDao);
  }

  @Bean
  public DomainEventDispatcher orderHistoryDomainEventDispatcher(OrderHistoryEventHandlers orderHistoryEventHandlers, MessageConsumer messageConsumer) {
    return new DomainEventDispatcher("orderHistoryDomainEventDispatcher", orderHistoryEventHandlers.domainEventHandlers(), messageConsumer);
  }

  @Bean
  public DuplicateMessageDetector duplicateMessageDetector() {
    return new NoopDuplicateMessageDetector();
  }
}