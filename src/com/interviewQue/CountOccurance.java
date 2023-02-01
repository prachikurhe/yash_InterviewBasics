package com.interviewQue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurance {
	public static void main(String[] args) {
		String word="wordW";
		Map<Character, Integer> map = new HashMap<>();
		char[] chars=word.toCharArray();
		for (char st : chars) {
			if (!map.containsKey(st)) {
				map.put(st, 1);
			} else {
				map.put(st, map.get(st) + 1);
			}
		}
		System.out.println(map);
		
		
		//By java8
		String str = "aaabccddddffg";
		List<String> list = Arrays.asList(str.split(""));

		Map<String, Long> map1 = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(map1);
		

	}

}
