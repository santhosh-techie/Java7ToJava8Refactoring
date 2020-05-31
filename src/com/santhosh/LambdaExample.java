package com.santhosh;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExample {
	//to print list of numbers
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		//Java 7 approach
		for(int i=0; i<numbers.size();i++) {
			System.out.println(numbers.get(i));
		}
		
		for(int e : numbers) {
			System.out.println(e);
		}
		
		//Java 8 approach
		 numbers.forEach(new Consumer<Integer>() {
		      public void accept(Integer number) {
		        System.out.println(number);
		      }
		    });
		 
		 numbers.forEach((Integer number) -> System.out.println(number));
		 
		 numbers.forEach(number -> System.out.println(number));
		 //method reference
		 numbers.forEach(System.out::println);
		 
	}

}
