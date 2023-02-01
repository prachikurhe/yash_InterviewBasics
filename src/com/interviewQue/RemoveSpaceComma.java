package com.interviewQue;

import java.util.Scanner;

/*
 * 1.Write a program to remove all comma(,) and all blank spance in given string.
i.e. Input- aa, bb cc dd, ee
Output- aabbccddee
 */

public class RemoveSpaceComma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create an object of Scanner
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the string");

		// take the input
//		String input = sc.nextLine();
//		System.out.println("Original String: " + input);

		// remove white spaces
//		input = input.replaceAll("\\s", "");
//		System.out.println("Final String: " + input);
//		sc.close();
		System.out.println("Hello");
		String s1="aa, bb, cc dd, ee,',";
//		s1=s1.replaceAll("\\s+", "").replaceAll(",+", "");
		s1=s1.replaceAll("\\s", "").replaceAll(",", "").replaceAll("'", "");
		System.out.println(s1);
	}

}
