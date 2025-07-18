package com.jaladhi.model;

public class Swapping {

	private int firstValue;
	private int secondValue;
	private String operation;

	public Swapping(int firstValue, int secondValue, String operation) {
		super();
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.operation = operation;
	}

	public int getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(int firstValue) {
		this.firstValue = firstValue;
	}

	public int getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(int secondValue) {
		this.secondValue = secondValue;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
