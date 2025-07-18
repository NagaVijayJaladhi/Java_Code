package com.jst;

import java.util.HashMap;

public class DemoClass {

	public static void main(String[] args) {
		String value = "AAAbbAAAAGHBBBAAaaaa";
		char [] ch = value.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < ch.length; i++) {
			if(map.containsKey(ch[i])) {
				map.put(ch[i], map.get(ch[i])+1);
			} else {
				map.put(ch[i], i);
			}
		}
		System.out.println(map);
	}
}
