package com.viewnext.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.viewnext.limitsservice.model.LimitConfiguration;
import com.viewnext.limitsservice.service.Configuration;
import com.viewnext.limitsservice.service.RabbitMQSender;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;
    
    @Autowired
    private RabbitMQSender sender;


    
	@GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations() {
		LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMaximum(),
   			 configuration.getMinimum());
   	sender.send(limitConfiguration);
   	 return limitConfiguration;
    }
	
    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
    public LimitConfiguration retrieveConfiguration() {
   	 throw new RuntimeException("Not available");
    }

    public LimitConfiguration fallbackRetrieveConfiguration() {
    	return new LimitConfiguration(999, 9);
    }

}
