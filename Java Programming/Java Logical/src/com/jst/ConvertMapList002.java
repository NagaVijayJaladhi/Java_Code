package com.jst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMapList002 {
	
	public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();
        students.put(132, "James");
		students.put(256, "Amy");
		students.put(115, "Young");
		System.out.println("Print Map: " + students);
		
		List<Integer> keyList = new ArrayList<Integer>(students.keySet());
		List<String> valueList = new ArrayList<String>(students.values());

		System.out.println("Key List: " + keyList);
		System.out.println("Value List: " + valueList);
        
    }

}
