package com.kihong.learn.java.phoneshop.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GeneralUtilsTest {
    
	@Test
	public void testToIntegerList() {
		//Given
		List<String> name= List.of("kihong","dara","socheata","thyda");
		
		//when
		   List<Integer> list = GeneralUtils.toIntegerList(name);
		//then
		   
		   assertEquals(4,list.size());
		   assertEquals(6,list.get(0));
		   assertEquals(4,list.get(1));
		   assertEquals(8,list.get(2));
		   assertEquals(5,list.get(3));
		  
	}
}
