package com.jaladhi.common;

import com.jaladhi.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranscationResponse {

	private Order order;
	private String amount;
	private String transcationId;
	private String message;
	
}
