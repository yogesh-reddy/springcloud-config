package com.myapp.food.delivery.orderservice.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.food.delivery.orderservice.domain.OrderServiceWithRepositoriesConfiguration;

import io.eventuate.javaclient.commonimpl.JSonMapper;

@Configuration
@ComponentScan
@Import(OrderServiceWithRepositoriesConfiguration.class)
public class OrderWebConfiguration {

  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    return JSonMapper.objectMapper;
  }

//  @Bean
//  public Sampler defaultSampler() {
//    return Sampler.ALWAYS_SAMPLE;
//  }

}
