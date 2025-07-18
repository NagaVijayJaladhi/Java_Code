package com.jst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1,"User 1", 1000));
		list.add(new Employee(2,"User 2", 1000));
		list.add(new Employee(3,"User 3", 900));
		list.add(new Employee(4,"User 4", 900));
		list.add(new Employee(5,"User 5", 900));
		list.add(new Employee(6,"User 6", 800));
		list.add(new Employee(7,"User 7", 800));
		list.add(new Employee(8,"User 8", 700));
		
		list.stream().forEach(li -> {
			for(int i = 0; i < list.size(); i++) {
				if(li.getSalary() > list.get(i).getSalary()) {
					
				}
			}
		});
	}
}
