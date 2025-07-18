// Find Maximum of Three Number
// Find Minimum of Three Number

package com.jst;

public class MaxThreeNo {
	
	public static void main(String[] args) {
		int n = 90, m = 50, p = 20;
		
		int max = (n > m) ? (n > p ? n : p) :(m > p ? m : p);
		System.out.println("Maximum of Three Number : " + max);
		
		int min = (n < m) ? (n < p ? n : p) : (m < p ? m : p);
		System.out.println("Minimum of Three Number : " + min);
	}
}
