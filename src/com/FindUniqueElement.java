package com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindUniqueElement {
	
	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(11,11,22,22,33,44,55);
		HashSet<Integer> set =new HashSet<>();
		
		list.stream().filter(a->set.add(a)).forEach(System.out::println);
		
		
	}

}
