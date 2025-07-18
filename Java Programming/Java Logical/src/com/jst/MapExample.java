package com.jst;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapExample {
	
	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Bala");
		map.put(2, "Raj");
		map.put(1, "Raja");
		
		System.out.println(map);
		

		List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
		System.out.println("List Values : " + list);
	
		Map<String, Long> map1 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println("Map Values : " + map1);
	}

}
