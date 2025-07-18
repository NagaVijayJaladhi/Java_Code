package com.jnv;


/*
A
B B
C C C
D D D D
E E E E E
F F F F F F

*/


public class AlphabetPattern {

	public static void main(String[] args) {
		
		int alphabet = 65;
		int rows = 5;
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print((char)alphabet + " ");
			}
			alphabet++;
			System.out.println();
		}
	}
}
