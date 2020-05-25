package com.santhosh;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import static java.util.Comparator.*;

public class Sample4 {
	
	//Create Helper method to print sorted list
	public static void printSorted(List<Person1> people, Comparator<Person1> comparator) {
		people.stream()
			  .sorted(comparator)
			  .forEach(System.out::println);
	}
	
	
	
	public static void main(String[] args) {
		
		//Java 7 Approach to compare and sort the list of persons
		//----Starts Here----
		List<Person> people = Arrays.asList(
				new Person("Sara", 12), 
				new Person("Mark", 43), 
				new Person("Bob", 12),
				new Person("Jill", 64));

		Collections.sort(people);

		System.out.println(people);
		//----Ends Here----
		// This is evil, we took the list and modified it. Also, we intruded into the Person class with Comparable.
		
		//Okay, lets demonstrate same in Java 8 -Comparable vs. Comparator -Composition of comparators
		//----Starts Here----
		
		List<Person1> people1 = Arrays.asList(
				new Person1("Sara", 12), 
				new Person1("Mark", 43), 
				new Person1("Bob", 12),
				new Person1("Jill", 64));
		
		Function<Person1, Integer>  byAge = Person1::getAge;
		Function<Person1, String>   byName = Person1::getName;
		
		
		printSorted(people1,comparing(byAge)); //Sara -- 12 Bob -- 12 Mark -- 43 Jill -- 64
		
		printSorted(people1,comparing(byName)); //Bob -- 12 Jill -- 64 Mark -- 43 Sara -- 12
		
		printSorted(people1,comparing(byAge).thenComparing(byName)); //Bob -- 12 Sara -- 12 Mark -- 43 Jill -- 64
		
		//----Ends Her----
	}
}
