package com.cn.zx.jdk18;

public interface InterfaceTest {

	// 这个是默认方法
	default String get(String aa, String bb) {
		System.out.println("我是jdk1.8默认实现方法...");
		return "";
	}

	String aa = "2222";

	// 这个是静态方法
	static void staticmethod() {
		System.out.println("我是静态方法" + aa);
	}
}
