package com.santhosh;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Sample2 {
	public static void main(String[] args) {
		  List<TimeSlot> timeSlots = Arrays.asList(
		    new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot());
		    
		  //...
		  
		 /* Java 7 approach */ 
		  //----Starts Here----
		  TimeSlot firstAvailableTimeSlot = null;
		  for(TimeSlot timeSlot : timeSlots) {
		    if(timeSlot.isAvailable()) {
		      timeSlot.schedule();
		      firstAvailableTimeSlot = timeSlot;
		      break;
		    }
		  }
		  
		  System.out.println("TimeSlot is " + firstAvailableTimeSlot);
		  //----Ends Here----
		  
		 /* JAVA 8 APPROACH -Code is transparent -Avoid the smell of null -Optional*/
		 //----Starts Here----
		  System.out.println("TimeSlot is " + timeSlots.stream()
		  			.filter(TimeSlot::isScheduleAvailable)
		  			.findFirst());
		 //----Ends Here---- 
	  }
}

class TimeSlot {
	  static Random random = new Random();
	  
	  public void schedule() {
	    //...
	  }
	  
	  public boolean isAvailable() {
	    return random.nextBoolean();
	  }
	  
	  // method to do whole instead of the part
	  public boolean isScheduleAvailable() {
		  boolean open = isAvailable();
		  if(open) schedule();
		  return open;
	  }
	}
