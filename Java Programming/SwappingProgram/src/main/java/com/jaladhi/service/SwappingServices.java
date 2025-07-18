package com.jaladhi.service;

import org.springframework.stereotype.Service;

import com.jaladhi.model.Swapping;

@Service
public interface SwappingServices {

	public String SINGLE_LINE = "Single Line Operation";
	public String BIT_WISE_XOR = "Bit Wise XOR Operation";
	public String MULTIPLE_DIVISION = "Multiple Division Operation";
	public String ADDITION_SUBTRACTION = "Addition Subtration Opertion";
	public String THIRD_VARIABLE = "Third Variable Operation";
	
	public Swapping singleLine(int a, int b);
	
	public Swapping bitWiseXor(int a, int b);
	
	public Swapping multipleDivision(int a, int b);
	
	public Swapping additionSubtraction(int a, int b);
	
	public Swapping thirdVariable(int a, int b);
	
}
