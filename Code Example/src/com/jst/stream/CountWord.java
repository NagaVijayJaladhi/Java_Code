package com.jst.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWord {

	public static void main(String[] args) {
		
		String str = "Hello, How are you ? What are you doing ?";
		
		Map<String, Long> countWord = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		countWord.forEach((k,v) -> System.out.println(k + " : " + v));
		
	}
}
