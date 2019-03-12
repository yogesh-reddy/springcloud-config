package com.myapp.food.delivery.orderservice.sagaparticipants;

import com.myapp.food.delivery.orderservice.domain.OrderRevision;

public class BeginReviseOrderCommand extends OrderCommand {

  private BeginReviseOrderCommand() {
  }

  public BeginReviseOrderCommand(long orderId, OrderRevision revision) {
    super(orderId);
    this.revision = revision;
  }

  private OrderRevision revision;

  public OrderRevision getRevision() {
    return revision;
  }

  public void setRevision(OrderRevision revision) {
    this.revision = revision;
  }
}
