package com.jst;

public final class ImmutableClass {

	private String name;
	private String city;

	public ImmutableClass() {
		super();
	}
	
	public ImmutableClass(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	
}
