package com.jst;

import java.util.ArrayList;
import java.util.Arrays;

public class DemoExample {
	
	public static void main(String[] args) {
		ArrayList strList = new ArrayList<>();
		strList.add("J");
		strList.add("A");
		strList.add("V");
		strList.add("A");
		
		strList.stream().distinct().forEach(System.out::println);
		
	}

}
