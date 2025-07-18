package com.jst;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciNo {
	
	public static void main(String[] args) {
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
		.limit(10)
		.map(t -> t[0])
		.forEach(x -> System.out.println(x));
		
		int sum = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
				.limit(10)
				.map(t -> t[0])
				.mapToInt(Integer::intValue)
				.sum();

		System.out.println("Total : " + sum);
		
		String collect = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .map(String::valueOf) // convert to string
                .collect(Collectors.joining(", "));

        System.out.println("Result : " + collect);
	}

}
