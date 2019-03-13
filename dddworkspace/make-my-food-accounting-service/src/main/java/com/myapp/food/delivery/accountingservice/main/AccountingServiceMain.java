package com.myapp.food.delivery.accountingservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.myapp.eventstore.examples.customersandorders.commonswagger.CommonSwaggerConfiguration;
import com.myapp.food.delivery.accountingservice.messaging.AccountingMessagingConfiguration;
import com.myapp.food.delivery.accountingservice.web.AccountingWebConfiguration;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import io.eventuate.tram.commands.common.ChannelMapping;
import io.eventuate.tram.commands.common.DefaultChannelMapping;
import io.eventuate.tram.commands.producer.TramCommandProducerConfiguration;



@SpringBootApplication
@Import({AccountingMessagingConfiguration.class, AccountingWebConfiguration.class,
        TramCommandProducerConfiguration.class,
        EventuateDriverConfiguration.class,
        TramJdbcKafkaConfiguration.class,CommonSwaggerConfiguration.class})
public class AccountingServiceMain {

  @Bean
  public ChannelMapping channelMapping() {
    return new DefaultChannelMapping.DefaultChannelMappingBuilder().build();
  }

  public static void main(String[] args) {
    SpringApplication.run(AccountingServiceMain.class, args);
  }
}
