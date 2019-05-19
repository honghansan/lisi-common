package com.lisi.test;

import org.junit.Test;

import com.lisi.utils.DateUtil;

public class DateTest {

	
	@Test
	public void test1() {
		String start = DateUtil.getStart("2018-12-15");
		System.out.println(start);
		String end = DateUtil.getEnd("2018-12-15");
		System.out.println(end);
	}
}
