package com.demo;

public class Building {

	Building() {
		System.out.println("Coding-Building");
	}

	Building(String name) {
		this();
		System.out.println("Coding-building: String Constructor" + name);
	}
}
