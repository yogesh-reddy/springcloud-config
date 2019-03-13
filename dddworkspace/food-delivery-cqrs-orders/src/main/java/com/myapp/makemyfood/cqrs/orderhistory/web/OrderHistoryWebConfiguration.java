package com.myapp.makemyfood.cqrs.orderhistory.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.myapp.makemyfood.cqrs.orderhistory.dynamodb.OrderHistoryDynamoDBConfiguration;

@Configuration
@ComponentScan
@Import(OrderHistoryDynamoDBConfiguration.class)
public class OrderHistoryWebConfiguration {
}
