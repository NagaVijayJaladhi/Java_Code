package com.jst;

import java.util.stream.IntStream;

public class PrimeNoAnyMatch {

	public static void main(String[] args) {
		int number = 67;
		boolean bol = !IntStream.rangeClosed(2, number/2).anyMatch(i -> number%i == 0);
		if(bol) {
			System.out.println(number + " is a Prime Number");
		} else {
			System.out.println(number + " is not a Prime Number");
		}
	}
}
