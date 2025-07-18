package com.jst.entity;

import java.util.Arrays;

public class OddNumber {

	public static void main(String [] args) {
		int [] in = {1,2,3,4,5,6,7,8,9};
		int inSum = Arrays.stream(in).filter(a -> a%2 == 0).map(b -> b + 10).sum();
		System.out.println("Odd Sum : " + inSum);
	}
}


//11 + 13 + 15 + 17 + 19