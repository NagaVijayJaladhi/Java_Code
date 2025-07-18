package com.jst.stream;

import java.util.Map;
import java.util.stream.Collectors;

public class CountCharacter {

	public static void main(String[] args) {
		
		String str = "Jaladhi Soft Technology";
		Map<Character, Long> countChar = str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		countChar.forEach((k,v) -> System.out.println(k + " : " + v));
	}
}
