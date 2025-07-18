package com.jaladhi.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaladhi.entity.Payment;
import com.jaladhi.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepo;
	
	public Payment doPayment(Payment payment) {
		payment.setStatus(paymentProcess());
		payment.setTranId(UUID.randomUUID().toString());
		return paymentRepo.save(payment);
	}
	
	private String paymentProcess() {
		return new Random().nextBoolean() ? "Success" : "Failure";
	}
}
