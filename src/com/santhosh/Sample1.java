package com.santhosh;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Sample1 {
	
	// Java 7 Approach helper method to determine whether a number is a prime.
	// ----Starts here----
	public static boolean isPrime(int number) {
	    boolean divisble = false;
	    
	    for (int i = 2; i < number; i++) {
	      if(number % i == 0) {
	        divisble = true;
	        break;
	      }
	    }
	    
	    return number > 1 && !divisble;
	  }
	//----Ends Here----
	
	// We can achieve same helper method in Java 8 using specialized functions, internal iterators, lazy evaluation, infinite streams
	//----Starts Here----
	public static boolean isPrimeUsingJava8(int number) {
		
		return number > 1 && 
			   IntStream.range(2,number)
			   			.noneMatch(index -> number % index == 0);
	}
	//----Ends Here----
	
	public static void main(String[] args) {
		  
		// Java 7 Approach of adding primes to the list
		//----Starts Here----
		List<Double> sqrtOfFirst100Primes = new ArrayList<>();
		  
		  int index = 1;
		  while(sqrtOfFirst100Primes.size() < 100) {
		    if(isPrime(index)) {
		      sqrtOfFirst100Primes.add(Math.sqrt(index));
		    }
		    
		    index++;
		  }
		 //----Ends Here----
		 
		 //Java 8 Approach will make use of streaming iterations to achieve the same
		 //----Starts Here----
		  List<Double> sqrtOfFirst100PrimesUsingJava8 =
				  		 Stream.iterate(1, e ->  e + 1) 
				  			   .filter(Sample1::isPrimeUsingJava8) // filtering only values that are prime only primes will be go to 58 line
				  			   .map(Math::sqrt) // map values to sqrt method
				  			   .limit(100)// only take 100 from infinity
				  			   .collect(toList()); //collect them to list of integer quietly
		  
		  //----Ends Here----
		  
		  
		  //Java 7 Output
		  System.out.println(
		    String.format("Computer %d values, first is %g, last is %g", 
		                   sqrtOfFirst100Primes.size(),
		                   sqrtOfFirst100Primes.get(0),
		                   sqrtOfFirst100Primes.get(sqrtOfFirst100Primes.size() - 1)));
		  
		// Java 8 output
		System.out.println(
		    String.format("Computer %d values, first is %g, last is %g", 
		    		sqrtOfFirst100PrimesUsingJava8.size(),
		    		sqrtOfFirst100PrimesUsingJava8.get(0),
		    		sqrtOfFirst100PrimesUsingJava8.get(sqrtOfFirst100PrimesUsingJava8.size() - 1)));
		  }
	
}	 
