package com.jst;

public class NumberPattern001 {
	public static void main(String[] args) {
		int n = 5;
		for(int i = 0; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
