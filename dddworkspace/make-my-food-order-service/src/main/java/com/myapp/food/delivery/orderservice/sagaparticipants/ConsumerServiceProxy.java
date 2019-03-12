package com.myapp.food.delivery.orderservice.sagaparticipants;

import com.myapp.food.delivery.consumerservice.api.ConsumerServiceChannels;
import com.myapp.food.delivery.consumerservice.api.ValidateOrderByConsumer;
import com.myapp.food.delivery.orderservice.api.OrderServiceChannels;

import io.eventuate.tram.commands.common.Success;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;

public class ConsumerServiceProxy {


  public final CommandEndpoint<ValidateOrderByConsumer> validateOrder= CommandEndpointBuilder
          .forCommand(ValidateOrderByConsumer.class)
          .withChannel(ConsumerServiceChannels.consumerServiceChannel)
          .withReply(Success.class)
          .build();

}
