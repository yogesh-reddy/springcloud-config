package com.myapp.makemyfood.cqrs.orderhistory.main;

import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.myapp.makemyfood.cqrs.orderhistory.messaging.OrderHistoryServiceMessagingConfiguration;
import com.myapp.makemyfood.cqrs.orderhistory.web.OrderHistoryWebConfiguration;
import com.myapp.makemyfood.customersandorders.commonswagger.CommonSwaggerConfiguration;

@SpringBootApplication
@Import({OrderHistoryWebConfiguration.class, OrderHistoryServiceMessagingConfiguration.class,
        TramJdbcKafkaConfiguration.class, CommonSwaggerConfiguration.class})
public class OrderHistoryServiceMain {

  public static void main(String[] args) {
    SpringApplication.run(OrderHistoryServiceMain.class, args);
  }
}
