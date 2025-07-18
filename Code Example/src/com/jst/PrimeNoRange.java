package com.jst;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNoRange {
	
	public static void main(String[] args) {
		int start = 0;
		int end = 10;
		List<Integer> list = IntStream.range(start, end).filter(x -> checkPrime(x)).boxed().collect(Collectors.toList());
		System.out.println("Display Prime Number : " + list);		
	}
	
	public static boolean checkPrime(int a) {
		return IntStream.range(2, a).noneMatch(i -> a%i == 0);
	}

	
	//range(1,5) 1,2,3,4
	//rangeClose(1, 5)  1,2,3,4,5
}
