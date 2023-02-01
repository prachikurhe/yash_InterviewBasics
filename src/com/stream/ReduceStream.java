package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceStream {
	public static void main(String[] args) {
		//Find longest string
		List<String>words=Arrays.asList("coreJava","Spring","hibernate");
		String longestString = words.stream().reduce((word1,word2)->word1.length()>word2.length()?word1:word2).get();
		System.out.println(longestString);
		
		List<Integer> numbers = Arrays.asList(1, 3, 2, 4, 5, 6, 7);
		int sum=numbers.stream().mapToInt(i->i).sum();
		System.out.println(sum);
		
	Integer reduceSum = numbers.stream().reduce(0, (a,b)->a+b);
	System.out.println(reduceSum);
	Optional<Integer> reduceSum2 = numbers.stream().reduce(Integer::sum);	
	System.out.println(reduceSum2);
	
	Integer reduceMul = numbers.stream().reduce(1, (a,b)->a*b);
	System.out.println(reduceMul);

		
	
		


	}

}
