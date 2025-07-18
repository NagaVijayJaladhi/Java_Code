package com.jst;

import java.util.stream.IntStream;

public class PrimeNoNoneMatch {

	public static void main(String[] args) {
		int number = 101;
		boolean bole = IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
		if(bole) {
			System.out.println(number + " is a Prime Number");
		} else {
			System.out.println(number + " is not a Prime Number");
		}
	}
}
