package com.somshine.webApp.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.somshine.webApp.model.Order;

@FeignClient(name="apiClientExamples")
public interface OrderServiceProxy {
	@GetMapping("order/get/{id}")
	public Order retrieveExchangeValue(@PathVariable("id") Long id);
}
