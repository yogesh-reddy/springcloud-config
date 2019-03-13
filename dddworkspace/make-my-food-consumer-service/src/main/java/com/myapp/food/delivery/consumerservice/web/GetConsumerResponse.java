package com.myapp.food.delivery.consumerservice.web;

import com.myapp.food.delivery.common.PersonName;
import com.myapp.food.delivery.consumerservice.api.web.CreateConsumerResponse;
import com.myapp.food.delivery.consumerservice.domain.Consumer;

public class GetConsumerResponse extends CreateConsumerResponse {
  private PersonName name;

  public PersonName getName() {
    return name;
  }

  public GetConsumerResponse(PersonName name) {

    this.name = name;
  }
}
