package com.jst;

import java.util.List;

public class Employee {

	public int id;
	public String name;
	public String dept;
	public List<Phone> phone;
	
	public Employee(int id, String name, String dept, List<Phone> phone) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.phone = phone;
	}	
	
	
}
