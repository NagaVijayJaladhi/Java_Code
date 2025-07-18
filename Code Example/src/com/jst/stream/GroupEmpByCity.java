package com.jst.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jst.entity.Employee;

public class GroupEmpByCity {

	public static void main(String[] args) {
		
		Map<String, List<Employee>> groupByCity = EmployeeList.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getCity));
		groupByCity.forEach((k,v) -> System.out.println(k + " : " + v));
		
	}
}
