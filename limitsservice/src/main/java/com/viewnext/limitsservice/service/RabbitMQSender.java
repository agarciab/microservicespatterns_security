package com.viewnext.limitsservice.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.limitsservice.model.LimitConfiguration;
import com.viewnext.limitsservice.model.RabbitMQPropertyConfiguration;

@Service
public class RabbitMQSender {
    
    
    @Autowired
    private AmqpTemplate rabbitTemplate;
    
    @Autowired
    RabbitMQPropertyConfiguration configuration;
    
    public void send(LimitConfiguration limits) {
   	 rabbitTemplate.convertAndSend(configuration.getExchange(), configuration.getRoutingkey(), limits);
   	 System.out.println("Send msg = " + limits);
   	 
    }
    
    
}
