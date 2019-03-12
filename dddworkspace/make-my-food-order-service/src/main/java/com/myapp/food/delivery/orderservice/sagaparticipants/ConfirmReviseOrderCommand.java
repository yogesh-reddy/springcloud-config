package com.myapp.food.delivery.orderservice.sagaparticipants;

import com.myapp.food.delivery.orderservice.domain.OrderRevision;

public class ConfirmReviseOrderCommand extends OrderCommand {

  private ConfirmReviseOrderCommand() {
  }

  public ConfirmReviseOrderCommand(long orderId, OrderRevision revision) {
    super(orderId);
    this.revision = revision;
  }

  private OrderRevision revision;

  public OrderRevision getRevision() {
    return revision;
  }
}
