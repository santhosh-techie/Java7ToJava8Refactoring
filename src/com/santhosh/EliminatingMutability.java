package com.santhosh;

import java.util.Arrays;
import java.util.List;

public class EliminatingMutability {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		//make each value double and find sum and return
	    
		//Java 7 Approach
		int totalOfValuesDoubled = 0;
		for(int number : numbers) {
			totalOfValuesDoubled += number * 2;
		}
	    // here we can see totalOfValuesDoubled value is mutating several times
		System.out.println(totalOfValuesDoubled);
		
		//Java 8 approach
		System.out.println(
					numbers.stream()	//open stream on collection
							.mapToInt(number -> number * 2)		//map every number in collection
							.sum());	//sum total
	}

}
