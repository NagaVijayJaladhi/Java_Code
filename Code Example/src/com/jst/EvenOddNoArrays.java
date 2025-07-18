package com.jst;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOddNoArrays {

	public static void main(String[] args) {
		
		int [] numbers = {10, 15, 8, 49, 25, 98, 32, 27, 12, 44, 91};
		System.out.println("Display Even Numbers : ");
		Arrays.stream(numbers).boxed().filter(x -> x%2 == 0).forEach(x -> System.out.print(x + " "));
		
		System.out.println("\n\nDisplay Odd Number : ");
		Arrays.stream(numbers).boxed().filter(y -> y%2 != 0).forEach(y -> System.out.print(y + " "));
		
		
		Map<Boolean, List<Integer>> list = Arrays.stream(numbers).boxed().collect(Collectors.partitioningBy(x -> x%2 == 0));
		System.out.println("\n\nEven and Odd Numbers : " + list);
		
	}
}
