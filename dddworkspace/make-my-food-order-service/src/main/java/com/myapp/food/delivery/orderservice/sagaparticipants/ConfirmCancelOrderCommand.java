package com.myapp.food.delivery.orderservice.sagaparticipants;

public class ConfirmCancelOrderCommand extends OrderCommand {

  private ConfirmCancelOrderCommand() {
  }

  public ConfirmCancelOrderCommand(long orderId) {
    super(orderId);
  }
}
