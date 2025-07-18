package com.demo;

import java.util.List;

public final class Employee {

	private final String name;
	private final double salary;
	private final List<String> address;
	
	public Employee(String name, double salary, List<String> address) {
		super();
		this.name = name;
		this.salary = salary;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public List<String> getAddress() {
		return address;
	}
		
}
