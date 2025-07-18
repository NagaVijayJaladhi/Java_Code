package com.jst;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 20, a = 0, b = 0, c = 1;
		System.out.println("For Loop Logic : ");
		forLoopLogic(n, b, c);
		System.out.println("\nWhile Loop Logic : ");
		whileLoop(n, b, c);
	}

	private static void forLoopLogic(int n, int b, int c) {
		int a;
		for(int i = 0; i <= n; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.print(a + " ");
		}
	}
	
	private static void whileLoop(int n, int b, int c) {
		int a, i = 0;
		while(i <= n) {
			a = b;
			b = c;
			c = a + b;
			System.out.print(a + " ");
			i++;
		}
	}
}
