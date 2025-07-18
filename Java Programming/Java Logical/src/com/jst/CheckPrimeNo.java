package com.jst;

import java.util.stream.IntStream;

public class CheckPrimeNo {
	
	public static void main(String[] args) {
		int number = 8;
		boolean bol1 = !IntStream.rangeClosed(2, number/2).anyMatch(i -> number%i == 0);
		boolean bile = IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
		if(bol1) {
			System.out.println("Prime Number");
		} else {
			System.out.println("Non Prime Number");
		}
		if(bile) {
			System.out.println("Prime Number");
		} else {
			System.out.println("Non Prime Number");
		}
	}

}
