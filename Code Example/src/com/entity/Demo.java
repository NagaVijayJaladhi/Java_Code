package com.entity;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {

	public static void main(String [] args) {
		extracted();
	}

	private static void extracted() {
		String input = "abcdbcd";
		Map<Character, Long> map = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		long count = map.entrySet().stream().filter(a -> a.getValue() == 1).count();
		System.out.println(count);
	}
}
