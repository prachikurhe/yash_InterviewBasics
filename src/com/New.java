package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class New {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=Arrays.asList(11,11,22,22,33,44,55);
		
		HashSet set=new HashSet<>();
		list.stream().filter(a->set.add(a)).forEach(System.out::println);
		
		
		
		
		
		


	}

}
