# Examples for Java 7 to Java 8 code transformation.

Java 8 is a major feature release of Java Programming Language. This project will explains the basic features of how to transform some parts
of Java 7 code with Java 8 lambda expressions and Stream API.


This project is having independent classes they are tested in my local computer and you can clone the project an run those 
examples on your local computer. To run the examples in this project you need Java 8 with support for lambda expressions. 

Take a few minutes to download the appropriate version of Java for your system. This will help you follow along with the examples in this project. 

The Oracle website for downloading the version of Java used in this project is <https://jdk8.java.net/download.html>.
 The JDK documentation is available at <http://download.java.net/jdk8/docs/api>.



#Functional Programming

The Java 8 design was heavily influenced by core principals of the functional programming.

* Functional programming is a cool and that are expressed as stateless transformations on immutable data.
* It is tend to be easier to read and maintain.
* It is to be less error prone and to parallelize more gracefully.

#Lambda Expressions

Lambdas are the functional key to free us from the hassles of imperative programming. 

Let's start with a simple example of collection here we are asked to total the prices greater than $20, discounted by 10%. Let's do in prior versions of Java.

```Java
	final List<BigDecimal> prices = Arrays.asList( 
							new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"), 
							new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
							new BigDecimal("45"), new BigDecimal("12"));

	BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;

	for(BigDecimal price : prices) { 
		if(price.compareTo(BigDecimal.valueOf(20)) > 0) totalOfDiscountedPrices = 													totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
	 } 
	 
	 System.out.println("Total of discounted prices: " + totalOfDiscountedPrices)							
```
we start with a mutable variable to hold the total of the discounted prices. We then loop through the prices, pick each price greater than $20, compute each item’s discounted value, and add those to the total. Finally we print the total value of the discounted prices. 

And here’s the output from the code. `Total of discounted prices: 67.5`.

Rather than tell Java to create a mutable variable and then to repeatedly assign to it, let’s talk with it at a higher level of abstraction, Java 8 comes with much shorter syntax, <b>lambda expressions</b>







 