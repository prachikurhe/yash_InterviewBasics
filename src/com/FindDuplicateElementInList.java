
//How to find duplicate elements in a given integers 
//list in java using Stream functions?

package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateElementInList {

	public static void main(String args[]) {
		List<Integer> myList = Arrays.asList(10, 15, 2, 2, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> set = new HashSet();
		myList.stream().filter(n -> !set.add(n)).forEach(System.out::println);

		//or 
		Set<Integer> collect3 = myList.stream().filter(n1 -> Collections.frequency(myList, n1) > 1)
				.collect(Collectors.toSet());
		System.out.println(collect3);

		
		
//		//write set
//		Set<Integer> collect = myList.stream().filter(a -> !set.add(a)).collect(Collectors.toSet());
//		System.out.println(collect);
        
		//Remove duplicate elements from set
		Set<Integer> collect2 = myList.stream().filter(n -> Collections.frequency(myList, n) == 1)
				.collect(Collectors.toSet());
		System.out.println(collect2);

	}

}
