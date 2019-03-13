package com.myapp.makemyfood.cqrs.orderhistory.messaging;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;
import io.eventuate.tram.messaging.common.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myapp.makemyfood.cqrs.orderhistory.DeliveryPickedUp;
import com.myapp.makemyfood.cqrs.orderhistory.Location;
import com.myapp.makemyfood.cqrs.orderhistory.OrderHistoryDao;
import com.myapp.makemyfood.cqrs.orderhistory.dynamodb.Order;
import com.myapp.makemyfood.cqrs.orderhistory.dynamodb.SourceEvent;
import com.myapp.makemyfood.orderservice.api.events.OrderCreatedEvent;
import com.myapp.makemyfood.orderservice.api.events.OrderState;

import java.util.Optional;

public class OrderHistoryEventHandlers {

  private OrderHistoryDao orderHistoryDao;

  public OrderHistoryEventHandlers(OrderHistoryDao orderHistoryDao) {
    this.orderHistoryDao = orderHistoryDao;
  }

  private Logger logger = LoggerFactory.getLogger(getClass());

  // TODO - determine events

  private String orderId;
  private Order order;
  private Location location; //

  public DomainEventHandlers domainEventHandlers() {
    return DomainEventHandlersBuilder
            .forAggregateType("com.myapp.makemyfood.orderservice.domain.Order")
            .onEvent(OrderCreatedEvent.class, this::handleOrderCreated)
//            .onEvent(DeliveryPickedUp.class, this::handleDeliveryPickedUp)
            .build();
  }

  private Optional<SourceEvent> makeSourceEvent(DomainEventEnvelope<?> dee) {
    return Optional.of(new SourceEvent(dee.getAggregateType(),
            dee.getAggregateId(), dee.getEventId()));
  }

  public void handleOrderCreated(DomainEventEnvelope<OrderCreatedEvent> dee) {
    logger.debug("handleOrderCreated called {}", dee);
    boolean result = orderHistoryDao.addOrder(makeOrder(dee.getAggregateId(), dee.getEvent()), makeSourceEvent(dee));
    logger.debug("handleOrderCreated result {} {}", dee, result);
  }

  private Order makeOrder(String orderId, OrderCreatedEvent event) {
    return new Order(orderId,
            Long.toString(event.getOrderDetails().getConsumerId()),
            OrderState.APPROVAL_PENDING,
            event.getOrderDetails().getLineItems(),
            event.getOrderDetails().getOrderTotal(),
            event.getOrderDetails().getRestaurantId(),
            event.getRestaurantName());
  }

  public void handleDeliveryPickedUp(DomainEventEnvelope<DeliveryPickedUp>
                                             dee) {
    orderHistoryDao.notePickedUp(dee.getEvent().getOrderId(),
            makeSourceEvent(dee));
  }
/*

  // TODO - need a common API that abstracts message vs. event sourcing

  public void handleOrderCancelled() {

    orderHistoryDao.cancelOrder(orderId, null);
  }

  public void handleTicketPreparationStarted() {
    orderHistoryDao.noteTicketPreparationStarted(orderId);
  }

  public void handleTicketPreparationCompleted() {
    orderHistoryDao.noteTicketPreparationCompleted(orderId);
  }

  public void handleDeliveryLocationUpdated() {
    orderHistoryDao.updateLocation(orderId, location);
  }

  public void handleDeliveryDelivered() {
    orderHistoryDao.noteDelivered(orderId);
  }
  */
}
