package com.stream;

import java.util.Optional;

public class OptionalClass {
	public static void main(String[] args) {
		String str=null;
		Optional<String> ofNullable = Optional.ofNullable(str);
		System.out.println(ofNullable.isPresent());
//		System.out.println(ofNullable.get());
		System.out.println(ofNullable.orElse("No value is this object"));
	}
	

}
