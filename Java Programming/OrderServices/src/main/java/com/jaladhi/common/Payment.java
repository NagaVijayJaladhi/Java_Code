package com.jaladhi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	private String id;
	private String status;
	private String tranId;
	private String orderId;
	private String amount;
	
}
