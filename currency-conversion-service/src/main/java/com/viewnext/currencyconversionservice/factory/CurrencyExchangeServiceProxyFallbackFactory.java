package com.viewnext.currencyconversionservice.factory;

import org.springframework.stereotype.Component;

import com.viewnext.currencyconversionservice.fallback.CurrencyExchangeServiceProxyFallback;
import com.viewnext.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

import feign.hystrix.FallbackFactory;

@Component
public class CurrencyExchangeServiceProxyFallbackFactory implements FallbackFactory<CurrencyExchangeServiceProxy> {

    @Override
    public CurrencyExchangeServiceProxy create(Throwable cause) {
   	 return new CurrencyExchangeServiceProxyFallback();
    }  

}
