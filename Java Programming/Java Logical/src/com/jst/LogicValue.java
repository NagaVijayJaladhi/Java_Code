package com.jst;

import java.util.Arrays;

public class LogicValue {
	
	public static void main(String[] args) {
		
		int a [] = {2,6,3,9,11};

		Arrays.stream(a).filter(i -> a[i] + a[i+1] == 9).limit(4).map(c -> c).forEach(an -> System.out.print(an));
	
	}

}
