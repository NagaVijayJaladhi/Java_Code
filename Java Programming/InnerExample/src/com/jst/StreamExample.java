package com.jst;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(45);
		list.add(1);
		list.add(56);
		list.add(18);
		list.add(111);
		list.add(156);
		list.add(0);
		list.add(187);
		
		for(Integer in : list) {
			if(in%9 == 0) {
				System.out.println(in);
			}
		}
	}
}
