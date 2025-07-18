package com.jnv;

public class KShapeCharPattern {

	public static void main(String[] args) {
		int n = 5;
		int i, j;
		int alphabet = 65;
		for(i = n; i >= 0; i--) {
			//int alphabet = 65;
			for(j = 0; j <= i; j++) {
				System.out.print((char) (alphabet + j) + " ");
			}
			System.out.println();
		}
		for(i = 0; i <= n; i++) {
			//int alphabet = 65;
			for(j = 0; j <= i; j++) {
				System.out.print((char) (alphabet + j) + " ");
			}
			System.out.println();
		}
	}
}
