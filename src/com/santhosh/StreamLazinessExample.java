package com.santhosh;

import java.util.Arrays;
import java.util.List;

public class StreamLazinessExample {
	
	public static boolean isGreaterThan3(int number) {
	    return number > 3;
	  }
	  
	public static boolean isEven(int number) {
	    return number % 2 == 0;
	  }
	  
	public static int doubleIt(int number) {
	    return number * 2;
	  }
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

	    //double the first even number greater than 3 from the list
		
		//functional programming is functional composition + lazy evaluation
		
		//streams are lazy
		//streams have two kind of methods
		//intermediate and terminal
		//intermediate (those that return stream) don't do any work
		//until a terminal method kicks in
		
		System.out.println(
				numbers.stream()
					   .filter(StreamLazinessExample::isGreaterThan3)
					   .filter(StreamLazinessExample::isEven)
					   .mapToInt(StreamLazinessExample::doubleIt)
					   .findFirst() //comment out this and next line and run
					   .getAsInt()	
				);
		
		//Stream does not run a function for each element
		//Instead it runs an element through a collection of functions
		//but only as necessary
		
	}

}
