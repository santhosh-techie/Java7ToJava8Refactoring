# Examples for Java 7 to Java 8 code transformation.

Java 8 is a major feature release of Java Programming Language. This project will explains the basic features of how to transform some parts
of Java 7 code with Java 8 lambda expressions and Stream API.


This project is having independent classes they are tested in my local computer and you can clone the project an run those 
examples on your local computer. To run the examples in this project you need Java 8 with support for lambda expressions. 

Take a few minutes to download the appropriate version of Java for your system. This will help you follow along with the examples in this project. 

The Oracle website for downloading the version of Java used in this project is [Java 8]https://jdk8.java.net/download.html.
 The JDK documentation is available at [Java 8 Docs]http://download.java.net/jdk8/docs/api.

# Lambda Expressions

Lambdas are the functional key to free us from the hassles of imperative programming. 

Let's start with a simple example of how to print a list of numbers in prior versions of Java:

```Java
	List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
	//version 1
	for(int i=0; i<numbers.length; i++){
		System.out.println(i);
	} 
	//version 2
	for(int number : numbers){
		System.out.println(number);
	}
```
Both these versions are external iterators, which mix how we do it with what we’d like to achieve.
We explicitly control the iteration with them, indicating where to start and where to end.
The second version does that under the hood using the Iterator methods. With explicit control, the break and continue statements can also help manage the iteration’s flow of control. 

Both of these styles, however, are imperative and we can dispense with them in modern Java as below.
Let’s use an internal iterator to enumerate the numbers. The Iterable interface has been enhanced in JDK 8 with a special method
named `forEach()`, which accepts a parameter of type `Consumer`. As the name indicates, an instance of Consumer will consume,
through its `accept()` method, what was given to it.

```Java
numbers.forEach(new Consumer<Integer>() {
			 public void accept(final Integer number) 
			 	{ System.out.println(number); }
			  }); 
```
We invoked the `forEach()` on the numbers collection and passed an anonymous instance of Consumer to it.
The `forEach()` method will invoke the `accept()` method of the given Consumer for each element in the collection and 
let it do whatever it wants with it. In this example we merely print the given value, which is the number. 

We can now replace the anonymous inner class with our lambda expression. 

```Java
    numbers.forEach((Integer number) -> System.out.println(number));
``` 
The variable number is bound to each to element of the collection during call.
The standard syntax for lambda expressions expects the parameters to be enclosed in parentheses, with the type information provided and comma separated.
The Java compiler treats single-parameter lambda expressions as special. We can leave off parenthesis around the parameter.
Also the java compiler is aware of the parameter types so you can skip them as well. And the code looks as below.

```Java
	numbers.forEach(number -> System.out.println(number));
```
As you can see the code is much shorter and easier to read. But it gets even shorter:

```Java
	numbers.forEach(System.out::println);
```
In the preceding code we used a `method reference`. Java lets us simply replace the body of code with the method name of our choice

# Functional Programming

The Java 8 design was heavily influenced by core principals of the functional programming.

* Functional programming is a cool and that are expressed as stateless transformations on immutable data.
* It is tend to be easier to read and maintain.
* It is to be less error prone and to parallelize more gracefully.

# Example of Functional Programming

Let's start with a simple example of collection here we are asked to total the prices greater than $20, discounted by 10%. Let's do in prior versions of Java.

```Java
	final List<BigDecimal> prices = Arrays.asList( new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"), 
							new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
							new BigDecimal("45"), new BigDecimal("12"));

	BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;

	for(BigDecimal price : prices) { 
		if(price.compareTo(BigDecimal.valueOf(20)) > 0)
		 totalOfDiscountedPrices = totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
	 } 
	 
	 System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);							
```
we start with a mutable variable to hold the total of the discounted prices. We then loop through the prices, pick each price greater than $20, compute each item’s discounted value, and add those to the total. Finally we print the total value of the discounted prices. 

And here’s the output from the code. `Total of discounted prices: 67.5`.

Rather than tell Java to create a mutable variable and then to repeatedly assign to it, let’s talk with it at a higher level of abstraction, Java 8 comes with much shorter syntax, <b>lambda expressions</b>

```Java
	final BigDecimal totalOfDiscountedPrces = prices.stream()
													.filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
													.map(price -> price.multiply(BigDecimal.valueOf(0.9)))
													.reduce(BigDecimal.ZERO, BigDecimal::add);
	
	System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);												
```

Let's read that loud --- filter prices greater than $20, map the prices to the discounted value and then add them up. 
The code is concise, but we are using quite a number of new things from Java 8. 
* First, we invoked a `stream()` method on the `prices` list. This opens the door to a special iterator.
* Instead of explicitly iterating through the prices list, we’re using a few special methods, such as `filter()` and `map()`.
* These methods take an anonymous function i.e. lambda expression as a parameter within parenthesis().
* We invoked the `reduce()` method to compute the total on the result of the `map()` method.

Here’s the output from this version of code: `Total of discounted prices: 67.5`.
  



 