package com.jst;

public class AlphabetPattern001 {

	public static void main(String[] args) {
		int alphabet = 65;
		int rows = 5;
		for(int i = 0; i <= rows; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print((char)(alphabet+j) + " ");
			}
			System.out.println();
		}
	}
}
