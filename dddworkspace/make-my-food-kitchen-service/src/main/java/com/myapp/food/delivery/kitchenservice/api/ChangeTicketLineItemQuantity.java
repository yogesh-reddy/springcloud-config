package com.myapp.food.delivery.kitchenservice.api;


import io.eventuate.tram.commands.common.Command;

public class ChangeTicketLineItemQuantity implements Command {
  public ChangeTicketLineItemQuantity(Long orderId) {
  }
}
