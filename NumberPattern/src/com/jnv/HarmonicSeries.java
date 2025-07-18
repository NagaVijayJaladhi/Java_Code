package com.jnv;

public class HarmonicSeries {

	public static void main(String[] args) {
		int n = 6;
		double res = 0.0;
		while(n > 0) {
			res = res + (double)1/n;
			n--;
		}
		System.out.println("Harmonic Series : " + res);
	}
}
