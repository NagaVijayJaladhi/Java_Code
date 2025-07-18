package com.jst.logic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DemoExample {
	
	public static void main(String[] args) {
		
		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5), Arrays.asList(6, 7, 8));
		//List<Integer> merge = listOfLists.stream().flatMap(a -> a).collect(Collectors.toList());
//		System.out.println(merge);
		
		int [] a = {2,5,9,4,8,10};
		int [] b = {2,5,9,4,8,10};
		Arrays.stream(a).sorted().min();
		
		IntStream.concat(Arrays.stream(a), Arrays.stream(b)).boxed().sorted().collect(Collectors.toList());
		
		 
	}

}
