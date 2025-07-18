package com.jst.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EachCharacter {

	public static void main(String[] args) {
		
		String str = "Jaladhi Soft Technology";
		Map<String, Long> countChar = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		countChar.forEach((k,v) -> System.out.println("Character : " + k + "\nCount : " + v));
		
	}
}
