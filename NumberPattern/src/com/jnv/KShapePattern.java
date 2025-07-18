package com.jnv;

public class KShapePattern {
	
	public static void main(String [] args) {
		
		int i,j,n = 5;
		for(i = n; i >= 1; i--) {
			for(j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(i = 2; i <= n; i++) {
			for(j = 1; j <=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
