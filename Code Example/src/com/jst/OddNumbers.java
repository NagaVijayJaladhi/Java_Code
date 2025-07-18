package com.jst;

import java.util.Arrays;
import java.util.List;

public class OddNumbers {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 38, 33);
		list.stream().filter(x -> x%2 != 0).forEach(x -> System.out.println(x));
	}

}
