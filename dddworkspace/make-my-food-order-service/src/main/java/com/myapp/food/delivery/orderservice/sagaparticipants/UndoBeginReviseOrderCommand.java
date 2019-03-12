package com.myapp.food.delivery.orderservice.sagaparticipants;

public class UndoBeginReviseOrderCommand extends OrderCommand {

  protected UndoBeginReviseOrderCommand() {
  }

  public UndoBeginReviseOrderCommand(long orderId) {
    super(orderId);
  }
}
