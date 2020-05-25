package com.santhosh;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;

public class Sample3 {
	public static void main(String[] args) {
		  
		//Java 7 Approach to read the files inside the directory
		//----Starts Here----
		  File aDirectory = new File(".");
		  
		  List<String> filesInDir = new ArrayList<>();
		  for(File child : aDirectory.listFiles()) {
		    filesInDir.add(child.getName());
		  }
		  
		  for(int i = 0; i < filesInDir.size(); i++) {
		    System.out.print(filesInDir.get(i));
		    if(i != filesInDir.size() - 1)
		      System.out.print(", ");
		  }
		  System.out.println();
		//--Ends Here--
		  
		// The same thing we can approach in Java 8 using higher level of abstractions
		//----Starts Here----  
		  File bDirectory = new File(".");
		  System.out.println(
				  Stream.of(bDirectory.listFiles()) //the of method transforms an array into a stream
				  		.map(File::getName)
				  		.collect(joining(", ")));
		//----Ends Here----		  
	}
}
