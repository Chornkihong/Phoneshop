package com.kihong.learn.java.phoneshop.utils;

import java.util.List;

public class GeneralUtils {
 
	
	public static List<Integer> toIntegerList(List<String> list){
		return list.stream()
			.map(s->s.length())
			.toList();
		
	}
	
}
