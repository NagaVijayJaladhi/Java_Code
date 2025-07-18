package com.jaladhi.service;

import org.springframework.stereotype.Service;

import com.jaladhi.model.Swapping;

@Service
public class SwappingServicesImpl implements SwappingServices {

	@Override
	public Swapping singleLine(int a, int b) {
		b = a + b - (a - b);
		return new Swapping(a, b, SINGLE_LINE);
	}

	@Override
	public Swapping bitWiseXor(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		return new Swapping(a, b, BIT_WISE_XOR);
	}

	@Override
	public Swapping multipleDivision(int a, int b) {
		a = a * b;
		b = a / b;
		a = a / b;
		return new Swapping(a, b, MULTIPLE_DIVISION);
	}

	@Override
	public Swapping additionSubtraction(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
		return new Swapping(a, b, ADDITION_SUBTRACTION);
	}

	@Override
	public Swapping thirdVariable(int a, int b) {
		int t = a;
		b = a;
		a = t;
		return new Swapping(a, b, THIRD_VARIABLE);
	}

}
