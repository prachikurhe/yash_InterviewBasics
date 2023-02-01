package com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterOccuranceInString {

	public static void main(String[] args) {

		String str = "aaabccddddffg";
		List<String> list = Arrays.asList(str.split(""));

		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(map);
		
		

	}

}
