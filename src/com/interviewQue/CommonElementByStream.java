package com.interviewQue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonElementByStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 1, 2, 5, 5, 8, 9, 7, 10 };
		int[] array2 = { 1, 0, 6, 15, 6, 4, 7, 0 };

		List<Integer> l1 = Arrays.asList(1, 2, 5, 5, 8, 9, 7, 10);
		List<Integer> l2 = Arrays.asList(1, 0, 6, 15, 6, 4, 7, 0);
		List<Integer> l3 = new ArrayList<>();

		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		Set<Integer> L1 = l1.stream().filter(n -> set1.add(n)).collect(Collectors.toSet());
		System.out.println(L1);
		Set<Integer> L2 = l2.stream().filter(n -> set2.add(n)).collect(Collectors.toSet());
		System.out.println(L2);
		l3.addAll(L1);
		l3.addAll(L2);
		System.out.println(l3);
		Set<Integer> set = new HashSet<>();
		l3.stream().filter(n -> !set.add(n)).forEach(System.out::println);
////////or
		Set<Integer> l4 = l3.stream().filter(n -> Collections.frequency(l3, n) > 1).collect(Collectors.toSet());

		System.out.println(l4);

	}

}

//myList.stream().filter(n -> !set.add(n)).forEach(System.out::println);
//Set<Integer> collect2 = myList.stream().filter(n -> Collections.frequency(myList, n) == 1)
//.collect(Collectors.toSet());