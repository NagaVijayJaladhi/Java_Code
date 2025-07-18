package com.jst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMapList005 {
	
	public static void main(String[] args) {
		Map<Integer, String> students = new HashMap<>();
        students.put(132, "James");
		students.put(256, "Amy");
		students.put(115, "Young");
		System.out.println("Print Map: " + students);
		List<Integer> keyList = students.keySet()
		        .stream()
		        .collect(Collectors.toCollection(ArrayList::new));
		List<String> valueList = students.values()
		        .stream()
		        .collect(Collectors.toCollection(ArrayList::new));

		System.out.println("Key list: " + keyList);
		System.out.println("Value list: " + valueList);
	}

}
