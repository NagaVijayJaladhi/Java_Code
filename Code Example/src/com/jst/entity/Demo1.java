package com.jst.entity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo1 {

	public static void main(String[] args) {
        int[] input = {3, 3, 1, 2, 1, 4, 3};
        int[] output = sortByFrequency(input);
        System.out.println(Arrays.toString(output));
    }

    public static int[] sortByFrequency(int[] arr) {
        Map<Integer, Long> frequencyMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return Arrays.stream(arr).boxed().sorted(Comparator.<Integer, Long>comparing(frequencyMap::get).reversed().thenComparing(Integer::intValue))
                .mapToInt(Integer::intValue).toArray();
    }
}
