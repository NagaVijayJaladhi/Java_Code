package com.jst;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToListMethod {
	public static void main(String[] args) {
		int a [] = {1,2,3,4,5,6,7,8,9,10};
		List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
		System.out.println("ToList Method in Collectors : " + list);
		
		List<Integer> list1 = Arrays.asList(2,3,4,5,6,9,8,7,1);
		List<Integer> disList = list1.stream().collect(Collectors.toList());
		System.out.println("Convert List : " + disList);
		
	}
}
