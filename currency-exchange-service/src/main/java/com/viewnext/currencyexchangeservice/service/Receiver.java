package com.viewnext.currencyexchangeservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.viewnext.currencyexchangeservice.model.LimitsConfiguration;

@Component
public class Receiver {


	@RabbitListener(queues="${limits-event.rabbitmq.queue}")
	public void receiveMessage(LimitsConfiguration message) {
    	System.out.println("Received <" + message + ">");
	}

}
