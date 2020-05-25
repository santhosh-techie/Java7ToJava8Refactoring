package com.santhosh;

public class Person1 {
	private final String name;
	private final int age;

	public Person1(String theName, int theAge) {
		name = theName;
		age = theAge;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return String.format("%s -- %d", name, age);
	}
}
