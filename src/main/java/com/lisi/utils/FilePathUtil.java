package com.lisi.utils;

public class FilePathUtil {

	// 系统临时路径
	public static String getTempPath() {
		String path = System.getProperty("java.io.tmpdir");
		return path;
	}

//用户的当前的工作路径
	public static String getUserPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	// 用户的主目录
	public static String getHomePath() {
		String path = System.getProperty("user.home");
		return path;
	}

	// 获取类路径
	public static String getClassPath() {
		String path = System.getProperty("java.class.path");
		return path;
	}

}
