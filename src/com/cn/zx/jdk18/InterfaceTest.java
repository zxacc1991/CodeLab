package com.cn.zx.jdk18;

public interface InterfaceTest {

	// �����Ĭ�Ϸ���
	default String get(String aa, String bb) {
		System.out.println("����jdk1.8Ĭ��ʵ�ַ���...");
		return "";
	}

	String aa = "2222";

	// ����Ǿ�̬����
	static void staticmethod() {
		System.out.println("���Ǿ�̬����" + aa);
	}
}
