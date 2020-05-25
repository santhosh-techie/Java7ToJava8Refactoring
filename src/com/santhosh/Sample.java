package com.santhosh;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Sample {

	public static void main(String[] args) {
		ExecutorService ecs = Executors.newFixedThreadPool(10);
		
			/* Using Java 7 Approach 
			 *
			 *
				 for(int i=0; i<10; i++) {
					 final int index = i;
					ecs.submit(new Runnable() {
						public void run() {
							System.out.println("Running Task--"+ index);
						}
						
					});
				}
				
				System.out.println("Task started---");
				ecs.shutdown();
			*
			*
			*/
		
		    //Using Java 8 Approach
		    // Deodorizing Inner-classes: is the main aim in Java 8 
	 		IntStream.range(0,10)
	 				 .forEach(index -> ecs.submit(()-> System.out.println("Running Task--"+ index)));	
	 		System.out.println("Task started---");
			ecs.shutdown();
		 
	}

}

