package com.jst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMapList004 {
	
	public static void main(String[] args) {
		Map<Integer, String> students = new HashMap<>();
        students.put(132, "James");
		students.put(256, "Amy");
		students.put(115, "Young");
		System.out.println("Print Map: " + students);
		List<Integer> keyList = students.keySet()
		        .stream()
		        .map(Integer::reverseBytes)
		        .collect(Collectors.toList());
		        
		System.out.println("Key list: " + keyList);
		
		List<String> valueList = students.values()
		        .stream()
		        .map(String::toLowerCase)
		        .collect(Collectors.toList());
		        
		System.out.println("Value list: " + valueList);
	}

}
