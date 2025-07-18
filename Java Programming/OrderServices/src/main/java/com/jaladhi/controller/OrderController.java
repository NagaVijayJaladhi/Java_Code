package com.jaladhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaladhi.common.Payment;
import com.jaladhi.common.TranscationRequest;
import com.jaladhi.common.TranscationResponse;
import com.jaladhi.entity.Order;
import com.jaladhi.service.OrderServices;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderServices orderServices;
	
	@PostMapping("/bookOrder")
	public TranscationResponse bookOrder(@RequestBody TranscationRequest request) {
		return orderServices.saveOrder(request);
	}
}
