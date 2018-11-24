package com.viewnext.currencyconversionservice.fallback;

import java.math.BigDecimal;

import com.viewnext.currencyconversionservice.model.CurrencyConversionBean;
import com.viewnext.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

public class CurrencyExchangeServiceProxyFallback implements CurrencyExchangeServiceProxy {
    @Override
    public CurrencyConversionBean retrieveExchangeValue(String from, String to) {
   	 return new CurrencyConversionBean(0L, "EUR", "USD", new BigDecimal(1), new BigDecimal(1), new BigDecimal(1), 0);
    }
}

