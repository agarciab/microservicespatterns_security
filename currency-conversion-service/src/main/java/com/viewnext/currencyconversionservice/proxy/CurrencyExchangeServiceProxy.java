package com.viewnext.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.viewnext.currencyconversionservice.factory.CurrencyExchangeServiceProxyFallbackFactory;
import com.viewnext.currencyconversionservice.model.CurrencyConversionBean;

@FeignClient(name="netflix-zuul-api-gateway-server",fallbackFactory=CurrencyExchangeServiceProxyFallbackFactory.class)
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
    
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue
   	 (@PathVariable("from") String from, @PathVariable("to") String to);
}

