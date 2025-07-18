package com.jst.stream;

import java.util.ArrayList;
import java.util.List;
import com.jst.entity.Employee;

public class EmployeeList {

	public static List<Employee> getEmployeeList() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "James", 28, 123, "F", "HR", "Bangalore", 2020));
		empList.add(new Employee(2, "Michael", 29, 120, "F", "HR", "New Delhi", 2015));
		empList.add(new Employee(3, "Robert ", 30, 115, "M", "HR", "Chennai", 2014));
		empList.add(new Employee(4, "John", 32, 125, "F", "HR", "Chennai", 2013));
		empList.add(new Employee(5, "David", 22, 150, "F", "IT", "Noida", 2013));
		empList.add(new Employee(6, "William", 27, 140, "M", "IT", "Gurugram", 2017));
		empList.add(new Employee(7, "Richard", 26, 130, "F", "IT", "Pune", 2016));
		empList.add(new Employee(8, "Joseph", 23, 145, "M", "Admin", "Trivandrum", 2015));
		empList.add(new Employee(9, "Jankanth", 25, 160, "M", "IT", "Bangalore", 2010));
		empList.add(new Employee(10, "Jennifer", 25, 160, "F", "HR", "Mumbai", 2011));
		return empList;
	}
}
