package com.lisi.test;

import org.junit.Test;

import com.lisi.utils.DateUtil;
import com.lisi.utils.FilePathUtil;

public class PathTest {

	
	@Test
	public void test1() {
		String path = FilePathUtil.getClassPath();
		System.out.println(path);
		String userPath = FilePathUtil.getUserPath();
		System.out.println(userPath);
		//String userPath = FilePathUtil.getTempPath();
		System.out.println(userPath);
		
	}
}
