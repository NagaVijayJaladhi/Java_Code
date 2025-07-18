package com.jst;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeDempt {
	
	public static void main(String[] args) {
		employeeDept();
	}
	
	
	public void employeePhone() {
		List<Employee> employeeList = Arrays.asList(new Employee(1, "John Doe", "HR", Arrays.asList(new Phone("primary", "1234567890"),
                new Phone("secondary", "9876543210"))), new Employee(2, "Jane Smith", "Finance", Arrays.asList(new Phone("primary", "5554443333"), new Phone("secondary", "6667778888"))),
				new Employee(3, "Alice Johnson", "IT", Arrays.asList(new Phone("secondary", "8889990000"))),
	            new Employee(4, "Robert Brown", "Marketing", Arrays.asList(new Phone("primary", "2223334444"))),
	            new Employee(5, "Emily Davis", "Operations", Arrays.asList(new Phone("primary", "7778889999"))));
		
		List<List<Phone>> phone = employeeList.stream().filter(emp -> emp.id == 2).map(emp -> emp.phone).collect(Collectors.toList());
		phone.stream().forEach(emp -> emp.stream().filter(e-> e.phoneType.equals("primary")).forEach(e -> System.out.print(e.phoneType)));
	}

	public static void employeeDept() {
		List<Person> persons = Arrays.asList(
			    new Person(1, "Alex", 100d, new Department(1, "HR")),
			    new Person(2, "Brian", 200d, new Department(1, "HR")),
			    new Person(3, "Charles", 900d, new Department(2, "Finance")),
			    new Person(4, "David", 200d, new Department(2, "Finance")),
			    new Person(5, "Edward", 200d, new Department(2, "Finance")),
			    new Person(6, "Frank", 800d, new Department(3, "ADMIN")),
			    new Person(7, "George", 900d, new Department(3, "ADMIN")));
		
		persons.stream().filter(p -> p.dept.name.equals("HR"));
		
		List<String> str = List.of("1", "2", "3", "4");
		
	}
}
