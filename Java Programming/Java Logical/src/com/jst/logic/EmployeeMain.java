package com.jst.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeMain {

	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
		empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
		empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
		empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));
		empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
		empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
		empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
		empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandrum", 2015));
		empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));

		Optional<Employee> empHighest = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst();
		
		Map<String, Optional<Employee>> highestPaidMFEmployee = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));
		
		System.out.println("Gender : " + highestPaidMFEmployee);
		
		Map<String, Optional<Employee>> highestDeptEmployee = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.maxBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));
		
		System.out.println("Deptment : " + highestDeptEmployee);

		Map<String, Object> list1 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.collectingAndThen(Collectors.toList(),list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst())));

		System.out.println("Deptment : " + list1);
	}
}
