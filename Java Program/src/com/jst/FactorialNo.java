package com.jst;

public class FactorialNo {
	public static void main(String[] args) {
		int n = 5, fact = 1;
		for(int i = 1; i <= n; i++) {
			fact *= i;
		}
		System.out.println("Factorial of " + n + " is : " + fact);
	}
}
