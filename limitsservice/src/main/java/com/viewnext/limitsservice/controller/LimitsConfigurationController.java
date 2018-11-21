package com.viewnext.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.limitsservice.model.LimitConfiguration;
import com.viewnext.limitsservice.service.Configuration;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    
	@GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations() {
   	 return new LimitConfiguration(configuration.getMaximum(),
   			 configuration.getMinimum());
    }

}
