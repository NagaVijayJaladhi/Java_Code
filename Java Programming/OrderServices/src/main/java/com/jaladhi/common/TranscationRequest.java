package com.jaladhi.common;

import com.jaladhi.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranscationRequest {

	private Order order;
	private Payment payment;
	
}
