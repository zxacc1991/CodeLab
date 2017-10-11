package com.cn.zx.jdk18;

public class Student {

	private String name;
	private int age;
	private String className;
	private String teacherName;
	
	
	public Student() {
		super();
	}
	public Student(String name, int age, String className, String teacherName) {
		super();
		this.name = name;
		this.age = age;
		this.className = className;
		this.teacherName = teacherName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", className="
				+ className + ", teacherName=" + teacherName + "]";
	}
}
