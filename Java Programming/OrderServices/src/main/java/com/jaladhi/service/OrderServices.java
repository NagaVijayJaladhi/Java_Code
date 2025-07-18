package com.jaladhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jaladhi.common.Payment;
import com.jaladhi.common.TranscationRequest;
import com.jaladhi.common.TranscationResponse;
import com.jaladhi.entity.Order;
import com.jaladhi.repository.OrderRepository;

@Service
public class OrderServices {

	@Autowired
	private OrderRepository orderRepo;	
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TranscationResponse saveOrder(TranscationRequest request) {
		String response = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		Payment paymentRes = restTemplate.postForObject("http://localhost:9191/payment/doPayment", request, Payment.class);
		response = paymentRes.getStatus().equals("Success") ? "Payment Process Success" : "Payment Process Failure";
		orderRepo.save(order);
		return new TranscationResponse(order, paymentRes.getAmount(), paymentRes.getTranId(), response);
	}
	
}
