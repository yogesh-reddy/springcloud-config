package com.myapp.food.delivery.kitchenservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.myapp.eventstore.examples.customersandorders.commonswagger.CommonSwaggerConfiguration;
import com.myapp.food.delivery.kitchenservice.messagehandlers.KitchenServiceMessageHandlersConfiguration;
import com.myapp.food.delivery.kitchenservice.web.KitchenServiceWebConfiguration;

import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import io.eventuate.tram.commands.common.ChannelMapping;
import io.eventuate.tram.commands.common.DefaultChannelMapping;

@SpringBootApplication
@Import({KitchenServiceWebConfiguration.class, KitchenServiceMessageHandlersConfiguration.class,
        TramJdbcKafkaConfiguration.class,CommonSwaggerConfiguration.class})
@EnableEurekaClient
public class KitchenServiceMain {

  @Bean
  public ChannelMapping channelMapping() {
    return new DefaultChannelMapping.DefaultChannelMappingBuilder().build();
  }

  public static void main(String[] args) {
    SpringApplication.run(KitchenServiceMain.class, args);
  }
}
