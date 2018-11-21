package com.viewnext.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viewnext.currencyexchangeservice.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{

	public ExchangeValue findByFromAndTo(String from, String to);
}
