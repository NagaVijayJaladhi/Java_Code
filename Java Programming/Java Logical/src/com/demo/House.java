package com.demo;

public class House extends Building {
	House() {
		System.out.println("Coding-House ");
	}

	House(String name) {
		this();
		System.out.println("Coding-house: String Constructor" + name);
	}

	public static void main(String[] args) {
		new House("Coding");
	}
}