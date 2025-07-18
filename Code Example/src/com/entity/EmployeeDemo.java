package com.entity;

import java.util.List;
import java.util.stream.Collectors;

import com.jst.Employee;
import com.jst.stream.EmployeeList;

public class EmployeeDemo {

	public static void main(String[] args) {
		
		List<Long> list = EmployeeList.getEmployeeList().stream().filter(emp -> emp.getDeptName().equals("IT")).map(emp -> emp.getSalary() * 2).collect(Collectors.toList());
		System.out.println("List : " + list);
		
		Double salary = EmployeeList.getEmployeeList().stream().filter(emp -> emp.getGender().equals("F")).collect(Collectors.averagingDouble(emp -> emp.getSalary()));
		System.out.println("Salary : " + salary);
	}
}
