package com.interviewQue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 2.Write a program to get unique data in given input.
i.e. Input- abc, xyz,xyz,cbd,abcd,abcd
Output- abc,cbd
 */
public class UniqueData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//    List<String>names=Arrays.asList("abc, xyz,xyz,cbd,abcd,abcd");
		String[] word = { "abc", "xyz", "xyz", "cbd", "abcd", "abcd" };

		Map<String, Integer> map = new HashMap<>();

		System.out.println("Hello");
		for (String st : word) {
			if (!map.containsKey(st)) {
				map.put(st, 1);
			} else {
				map.put(st, map.get(st) + 1);
			}
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println(entry.getKey() + " " + entry.getValue());

			}
		}
	}

}
