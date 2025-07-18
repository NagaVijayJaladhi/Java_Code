package com.jst;

import java.util.List;

public class Person {
	
	public int id;
	public String name;
	public double salary;
	public Department dept;
	
	public Person(int id, String name, double salary, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = department;
	}

}
