package com.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AllDemo {

	public static void main(String[] args) {
		/*int [] input = {10,8,6,5,6,15,10};
		int hv = Arrays.stream(input).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(hv);*/
		
		String [] str = {"aa","bb","cc","aa"};
		Map<String, Long> map = Arrays.stream(str).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		//System.out.println(map);
		
		String [] str1 = {"Java", "Python", "C#", "Java", "Kotlin", "Python"};
		//System.out.println("Remove Duplicates : " + str1.length);
		String str2 = Arrays.stream(str1).distinct().collect(Collectors.joining(","));
		String [] str3 = Arrays.stream(str1).distinct().toArray(String [] :: new);
		//System.out.println("Remove Duplicates : " + str2);
		
		List<String> sentences = List.of("Ravi is good in java", "Ravi is good in streams", "Ravi hardworking");
		Map<String, Long> map1 = sentences.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
}
