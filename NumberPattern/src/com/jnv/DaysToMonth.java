package com.jnv;

public class DaysToMonth {

	public static void main(String[] args) {
		int n = 365;
		int d = n%30;
		int m = n/30;
		System.out.println(n + " Days = " + m + " Months "+ d + " Days");
	}
}
