package com.jst;

public class NumberPattern003 {

	public static void main(String[] args) {
		int rows = 5, k = 1;
		for(int i = 0; i <= rows; i++) {
			for(int j = 1; j <= i + 1; j++) {
				System.out.print(k++ + " ");
			}
			System.out.println();
		}
	}
}
