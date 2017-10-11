package com.cn.zx.gc;

public class GcTest {
	public static void main(String[] args) {
		String str = "abc";
		String str1 = new String("abc").intern();
		System.out.println(str1);
		System.out.println(str == str1);
		
		final int[] aa = {1,2,3};
		int [] bb = {1,2};
		aa[2] = 200;
		for(int a : aa){
			System.out.println(a);
		}
	}
}
