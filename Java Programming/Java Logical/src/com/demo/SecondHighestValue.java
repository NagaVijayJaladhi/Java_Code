package com.demo;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHighestValue {

	public static void main(String[] args) {
		
		int [] arr = {12, 28, 9, 30, 19, 25, 8, 16, 23, 6, 22, 14};
		int secondValue = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).skip(0).findFirst().get();
		System.out.println("Second Highest Value is " + secondValue);
		
		String str = "Java Programming Language Arrays ArrayLists";
		Arrays.stream(str.split(" ")).filter(x -> x.startsWith("A")).forEach(b -> System.out.println(b));
	}
}
