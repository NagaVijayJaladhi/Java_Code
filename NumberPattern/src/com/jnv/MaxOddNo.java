package com.jnv;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class MaxOddNo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(43,12,67,90,89,76,12,106);
		System.out.println("Maximum Odd Number in List using Loop : " + whileLoop(list));
		System.out.println("Maximum Odd Number in List using Streams : " + streamApi(list));
	}

	private static int whileLoop(List<Integer> list) {
		int max = 0;
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			int num = it.next();
			if(num % 2 == 1) {
				if(num > max) {
					max = num;
				}
			}
		}
		return max;
	}
	
	private static int streamApi(List<Integer> list) {
		return list.stream().filter(k -> k%2 == 1).max(Integer::compare).orElse(0);
	}
}
