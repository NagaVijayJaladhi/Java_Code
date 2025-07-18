package com.jst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMapList006 {
	
	public static void main(String[] args) {
		Map<Integer, String> students = new HashMap<>();
	     students.put(132, "James");
		 students.put(256, "Amy");
		 students.put(115, "Young");
		 System.out.println("Print Map: " + students);
		 
		 List<String> sortedValueList = students.values()
			        .stream()
			        .sorted()
			        .collect(Collectors.toList());
			        
			System.out.println("Sorted Values: " + sortedValueList);
	}

}
