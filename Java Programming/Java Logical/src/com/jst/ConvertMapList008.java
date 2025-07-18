package com.jst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMapList008 {

	public static void main(String[] args) {
		Map<Integer, String> students = new HashMap<>();
	     students.put(132, "James");
		 students.put(256, "Amy");
		 students.put(115, "Young");
		 System.out.println("Print Map: " + students);
		 
		 Map<Integer, List<String>> newMap = new HashMap<>();

		 List<String> firstName = new ArrayList();
		 firstName.add(0, "Jon");
		 firstName.add(1, "Johnson");
		 List<String> secondName = new ArrayList();
		 secondName.add(0, "Peter");
		 secondName.add(1, "Malone");
		 newMap.put(1, firstName);
		 newMap.put(2, secondName);

		 List<String> valueList = newMap.values()
		         .stream()
		         .flatMap(e -> e.stream())
		         .collect(Collectors.toList());

		 System.out.println(valueList);
	}
}
