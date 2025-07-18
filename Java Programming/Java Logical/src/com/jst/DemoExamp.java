package com.jst;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DemoExamp {
	
	public static void main(String [] args) {
		
		String str = "Java Programming Language";		
		Map<Character,Long> map = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Map Value : " + map);
	}
}
