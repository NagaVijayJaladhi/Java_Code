package com.jst.entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo {
	 public static void main(String [] args) {
		 String str = "abcabcde";
		 Set<String> set = new HashSet();
		 Set<String> set1 = Arrays.stream(str.split("")).filter(s -> !set.add(s)).collect(Collectors.toSet());
		 System.out.println(set1);
		 System.out.println(set);
		 set.stream().noneMatch(b -> set1.contains(b));
		 System.out.println(set);
		
	 }
}
