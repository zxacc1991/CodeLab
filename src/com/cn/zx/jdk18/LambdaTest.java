package com.cn.zx.jdk18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;



public class LambdaTest {

	static List<String> names = Arrays.asList("b", "a", "d", "c");

	
	/**
	 * @Title: sortForList 
	 * @Description: jdk1.8之前的排序方法
	 * @Author: Gavin
	 * @Create Date: 2017年8月27日下午10:35:19
	 */
	public static void sortList(){
		long time = System.currentTimeMillis();  
	    Collections.sort(names, new Comparator<String>() {//java以前老版本的写法
	        @Override
	        public int compare(String a, String b) {
	            return b.compareTo(a);
	        }
	    });
	    System.out.println("耗时"+(System.currentTimeMillis()-time));  
	    for(String name:names){
	        System.out.println(name);
	    }
	}
	
	/**
	 * @Title: sortListNew 
	 * @Description: 使用Lambdas表达式重构排序方法(java1.8新特性)
	 * @Author: Gavin
	 * @Create Date: 2017年8月27日下午10:37:43
	 */
	public static void sortListNew(){
//		1.方法一
//		Collections.sort(names, (String a, String b) -> {
//			return b.compareTo(a);
//		});
		
//		2.方法二(优化方法一)
//		Collections.sort(names, (String a, String b) -> b.compareTo(a));
//		for(String name:names){
//		    System.out.println(name);
//		}
		
//      3.对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字，但是你还可以写得更短点：
		long time = System.currentTimeMillis();  
		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println("耗时"+(System.currentTimeMillis()-time));  
		//输出新格式
//		names.forEach(e -> System.out.println(e));
		names.forEach(System.out::println);
	}
	
	/**
	 * @Title: forEachStrings 
	 * @Description: 循环输出数组中的值
	 * @Author: Gavin
	 * @Create Date: 2017年8月27日下午10:44:30
	 */
	public static void forEachStrings(){
		Arrays.asList("b", "a", "d", "c").forEach(System.out::println);
	}

	/**
	 * @Title: sortListBeans 
	 * @Description: 根据list对象的某些属性排序
	 * @Author: Gavin
	 * @Create Date: 2017年8月27日下午10:46:39
	 */
	public static void sortListBeans(){
		List<Student> stus = new ArrayList<Student>();
		Student s1 = new Student("张三", 18, "六班", "练兵");
		Student s2 = new Student("李四", 19, "六班", "练兵2");
		Student s3 = new Student("王五", 10, "六班", "练兵3");
		String name = Optional.ofNullable(s1).map(Student::getName).orElse("no name");
		stus.add(s1);
		stus.add(s2);
		stus.add(s3);
//		1.循环输出时将学生的年龄*5
//		stus.forEach(e -> e.setAge(e.getAge() * 5));
//		stus.forEach(System.out::println);
		
//		2.利用filter过滤年龄大于19的学生
//		stus.stream()
//		.filter(p -> p.getAge() < 19)
//		.forEach(e -> System.out.printf("%s %s; ",e.getName(),e.getClassName()));
		
//		3.使用stream的sorted方法,根据学生年龄进行排序
//		stus.stream().sorted((p,p2) -> p.getAge() - p2.getAge());
		
//		4.使用collections方法的sort根据学生的名字排序
//		Collections.sort(stus, (p,p2) -> p.getName().compareTo(p2.getName()));
		
//		5.使用stream来进行排序
//		stus.stream()
//		.limit(3)
//		.sorted((p, p2) -> (p.getAge() - p2.getAge()))  
//        .forEach(e -> System.out.printf("%s %s; ",e.getName(),e.getClassName()));
		
	}
	
	public static void sortListMaps(){
		List<Map<String,String>> datas = new ArrayList<Map<String,String>>();
		Map<String,String> map1 = new HashMap<String, String>();
		map1.put("name", "张三");
		map1.put("age", "18");
		map1.put("className", "六班");
		
		Map<String,String> map2 = new HashMap<String, String>();
		map2.put("name", "李四");
		map2.put("age", "17");
		map2.put("className", "六班");
		
		Map<String,String> map4 = new HashMap<String, String>();
		map4.put("name", "孙六");
		map4.put("age", "20");
		map4.put("className", "六班");
		
		Map<String,String> map3 = new HashMap<String, String>();
		map3.put("name", "王五");
		map3.put("age", "19");
		map3.put("className", "六班");
		
		Map<String,String> map5 = new HashMap<String, String>();
		map5.put("name", "王五");
		map5.put("age", "19");
		map5.put("className", "六班");
		
		datas.add(map1);
		datas.add(map2);
		datas.add(map4);
		datas.add(map3);
		datas.add(map5);
		
//		1.根据map中的age字段进行排序
//		long time = System.currentTimeMillis();  
		Collections.sort(datas, (p,p1) -> p.get("age").compareTo(p1.get("age")));
//		System.out.println("耗时"+(System.currentTimeMillis()-time));  
//		175ms
		datas.forEach(System.out::println);
		
//		2.利用stream进行条件过滤,并循环输出
//		List<Map<String,String>> list = datas.stream()
//		.filter(p -> Integer.valueOf(p.get("age")) <= 18)
//		.limit(5)
//		.forEach(p -> System.out.printf("%s %s", p.get("name"),p.get("age")))
//		.collect(Collectors.toList());
//		list.forEach(System.out::println);
		
//		3.利用sorted进行排序并循环输出
//		long time1 = System.currentTimeMillis();  
//		datas.stream()
//		.limit(3) //这里limit是指排序后保留几个值
//		.sorted((p, p2) -> (Integer.valueOf(p.get("age"))) - (Integer.valueOf(p.get("age"))))
//		.forEach(p -> System.out.printf("%s %s", p.get("name"),p.get("age")));
//		System.out.println("耗时"+(System.currentTimeMillis()-time1));  
		//241ms
		
//		4.获取list对象中年龄最大的学生
//		Map<String,String> maxMap = datas.stream()
//		.max((p,p2) -> Integer.valueOf(p.get("age")) - Integer.valueOf(p2.get("age")))
//		.get();
//		System.out.println("最大年纪的同学是：["+maxMap.get("name")+"],年龄为：["+maxMap.get("age")+"]");
		
//		5.获取list对象中年龄最小的学生
//		Map<String,String> maxMap = datas.stream()
//		.min((p,p2) -> Integer.parseInt(p.get("age")) - Integer.valueOf(p2.get("age")))
//		.get();
//		System.out.println("最小年纪的同学是：["+maxMap.get("name")+"],年龄为：["+maxMap.get("age")+"]");
		
//		6.计算所有学生年龄之和
//		int totalAge = 
//		datas.parallelStream()  
//		.mapToInt(p -> Integer.parseInt(p.get("age")))  
//		.sum();  
//		System.out.println("所有学生的年龄之和为:" + totalAge);
		
//		7.Map循环
//		map1.forEach((k,v) -> System.out.println(k+" : "+v));
	}
	
	/**
	 * @Title: summaryStatistics 
	 * @Description: 获得stream 中元素的各种汇总数据
	 * @Author: Gavin
	 * @Create Date: 2017年8月28日上午12:05:58
	 */
	public static void summaryStatistics(){
		//计算 count, min, max, sum, and average for numbers  
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  
		IntSummaryStatistics stats = numbers  
		          .stream()  
		          .mapToInt((x) -> x)  
		          .summaryStatistics();  
		System.out.println("List中最大的数字 : " + stats.getMax());  
		System.out.println("List中最小的数字 : " + stats.getMin());  
		System.out.println("所有数字的总和   : " + stats.getSum());  
		System.out.println("所有数字的平均值 : " + stats.getAverage());  
	}
	public static void main(String[] args) {
		
//		接口可以定义静态方法
//		InterfaceTest.staticmethod();
		
//		jdk1.8之前的排序方法(耗时3ms)
//		sortList();
		
//		jdk1.8新特性(耗时220ms)
//		sortListNew();
		
//		数组循环输出
//		forEachStrings();
		
//		list对象排序
//		sortListBeans();
		
//	    list套map排序
		sortListMaps();
		
//		获得stream 中元素的各种汇总数据
//		summaryStatistics();
	}
}
