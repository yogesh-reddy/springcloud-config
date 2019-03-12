package com.myapp.food.delivery.orderservice.sagaparticipants;

public class RejectOrderCommand extends OrderCommand {

  private RejectOrderCommand() {
  }

  public RejectOrderCommand(long orderId) {
    super(orderId);
  }
}
