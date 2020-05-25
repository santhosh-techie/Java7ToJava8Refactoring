package com.santhosh;

public class Person implements Comparable<Person>{
	private final String name;
	private final int age;

	public Person(String theName, int theAge) {
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

	public int compareTo(Person other) {
		return ((Integer) (age)).compareTo(other.age);
	}
}
