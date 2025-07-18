package com.jst;

import java.util.stream.IntStream;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumber {
	
	public static void main(String[] args) {
		int start = 2;
		int end = 100;
		List<Integer> primeNumbers =
	            IntStream
	                    .range(start,end)
	                    .filter(number -> IntStream.range(2,number)
	                            .noneMatch(divider -> number % divider == 0))
	                    .boxed()
	                    .collect(Collectors.toList());
		System.out.println(primeNumbers);
	}
}
