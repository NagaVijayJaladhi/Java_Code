package com.jnv;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class MaxEvenNo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(13,45,70,23,57,76,89,107);
		System.out.println("Maximum Even Number in List using Loop : "+ whileLoop(list));
		System.out.println("Maximum Even Number in List using Stream : "+ streamApi(list));
		
		MaxEvenNo mev = new MaxEvenNo();
	}

	private static int whileLoop(List<Integer> list) {
		int max = 0;
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			int num = it.next();
			if(num % 2 == 0) {
				if(num > max) {
					max = num;
				}
			}
		}
		return max;
	}
	
	private static int streamApi(List<Integer> list) {
		return list.stream().filter(p -> p%2 == 0).max(Integer::compare).orElse(0);
	}
	
}
