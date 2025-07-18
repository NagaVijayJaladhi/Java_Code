package com.jst;

public class GCDProgram {
	public static void main(String[] args) {
		int n1 = 41, n2 = 91;
		int gcd = 1;
		for(int i = 1; i <= n1 && i <= n2; ++i) {
			if(n1%i == 0 && n2 %i == 0) {
				gcd = i;
			}
		}
		System.out.println("GCD of "+ n1 + " & " + n2 + " is " + gcd);
	}
}
