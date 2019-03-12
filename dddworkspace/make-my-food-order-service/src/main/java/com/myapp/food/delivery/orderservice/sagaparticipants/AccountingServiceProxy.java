package com.myapp.food.delivery.orderservice.sagaparticipants;

import com.myapp.food.delivery.accountservice.api.AccountingServiceChannels;
import com.myapp.food.delivery.accountservice.api.AuthorizeCommand;

import io.eventuate.tram.commands.common.Success;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;

public class AccountingServiceProxy {

  public final CommandEndpoint<AuthorizeCommand> authorize= CommandEndpointBuilder
          .forCommand(AuthorizeCommand.class)
          .withChannel(AccountingServiceChannels.accountingServiceChannel)
          .withReply(Success.class)
          .build();

}
