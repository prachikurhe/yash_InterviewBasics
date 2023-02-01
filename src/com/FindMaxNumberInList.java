
//Given a list of integers, find the maximum value
//element present in it using Stream functions?

package com;

import java.util.Arrays;
import java.util.List;

public class FindMaxNumberInList {

	public static void main(String args[]) {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		int max = myList.stream().max(Integer::compare).get();
		System.out.println(max);

		Integer integer = myList.stream().min(Integer::compare).get();
		System.out.println(integer);
//
		List<Integer> numbers = Arrays.asList(5, 9, 11, 2, 8, 21, 1);

		Integer integer2 = numbers.stream().reduce((a, b) -> a > b ? a : b).get();
		System.out.println(integer2);

	}

}
