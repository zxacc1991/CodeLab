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
	 * @Description: jdk1.8֮ǰ�����򷽷�
	 * @Author: Gavin
	 * @Create Date: 2017��8��27������10:35:19
	 */
	public static void sortList(){
		long time = System.currentTimeMillis();  
	    Collections.sort(names, new Comparator<String>() {//java��ǰ�ϰ汾��д��
	        @Override
	        public int compare(String a, String b) {
	            return b.compareTo(a);
	        }
	    });
	    System.out.println("��ʱ"+(System.currentTimeMillis()-time));  
	    for(String name:names){
	        System.out.println(name);
	    }
	}
	
	/**
	 * @Title: sortListNew 
	 * @Description: ʹ��Lambdas���ʽ�ع����򷽷�(java1.8������)
	 * @Author: Gavin
	 * @Create Date: 2017��8��27������10:37:43
	 */
	public static void sortListNew(){
//		1.����һ
//		Collections.sort(names, (String a, String b) -> {
//			return b.compareTo(a);
//		});
		
//		2.������(�Ż�����һ)
//		Collections.sort(names, (String a, String b) -> b.compareTo(a));
//		for(String name:names){
//		    System.out.println(name);
//		}
		
//      3.���ں�����ֻ��һ�д���ģ������ȥ��������{}�Լ�return�ؼ��֣������㻹����д�ø��̵㣺
		long time = System.currentTimeMillis();  
		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println("��ʱ"+(System.currentTimeMillis()-time));  
		//����¸�ʽ
//		names.forEach(e -> System.out.println(e));
		names.forEach(System.out::println);
	}
	
	/**
	 * @Title: forEachStrings 
	 * @Description: ѭ����������е�ֵ
	 * @Author: Gavin
	 * @Create Date: 2017��8��27������10:44:30
	 */
	public static void forEachStrings(){
		Arrays.asList("b", "a", "d", "c").forEach(System.out::println);
	}

	/**
	 * @Title: sortListBeans 
	 * @Description: ����list�����ĳЩ��������
	 * @Author: Gavin
	 * @Create Date: 2017��8��27������10:46:39
	 */
	public static void sortListBeans(){
		List<Student> stus = new ArrayList<Student>();
		Student s1 = new Student("����", 18, "����", "����");
		Student s2 = new Student("����", 19, "����", "����2");
		Student s3 = new Student("����", 10, "����", "����3");
		String name = Optional.ofNullable(s1).map(Student::getName).orElse("no name");
		stus.add(s1);
		stus.add(s2);
		stus.add(s3);
//		1.ѭ�����ʱ��ѧ��������*5
//		stus.forEach(e -> e.setAge(e.getAge() * 5));
//		stus.forEach(System.out::println);
		
//		2.����filter�����������19��ѧ��
//		stus.stream()
//		.filter(p -> p.getAge() < 19)
//		.forEach(e -> System.out.printf("%s %s; ",e.getName(),e.getClassName()));
		
//		3.ʹ��stream��sorted����,����ѧ�������������
//		stus.stream().sorted((p,p2) -> p.getAge() - p2.getAge());
		
//		4.ʹ��collections������sort����ѧ������������
//		Collections.sort(stus, (p,p2) -> p.getName().compareTo(p2.getName()));
		
//		5.ʹ��stream����������
//		stus.stream()
//		.limit(3)
//		.sorted((p, p2) -> (p.getAge() - p2.getAge()))  
//        .forEach(e -> System.out.printf("%s %s; ",e.getName(),e.getClassName()));
		
	}
	
	public static void sortListMaps(){
		List<Map<String,String>> datas = new ArrayList<Map<String,String>>();
		Map<String,String> map1 = new HashMap<String, String>();
		map1.put("name", "����");
		map1.put("age", "18");
		map1.put("className", "����");
		
		Map<String,String> map2 = new HashMap<String, String>();
		map2.put("name", "����");
		map2.put("age", "17");
		map2.put("className", "����");
		
		Map<String,String> map4 = new HashMap<String, String>();
		map4.put("name", "����");
		map4.put("age", "20");
		map4.put("className", "����");
		
		Map<String,String> map3 = new HashMap<String, String>();
		map3.put("name", "����");
		map3.put("age", "19");
		map3.put("className", "����");
		
		Map<String,String> map5 = new HashMap<String, String>();
		map5.put("name", "����");
		map5.put("age", "19");
		map5.put("className", "����");
		
		datas.add(map1);
		datas.add(map2);
		datas.add(map4);
		datas.add(map3);
		datas.add(map5);
		
//		1.����map�е�age�ֶν�������
//		long time = System.currentTimeMillis();  
		Collections.sort(datas, (p,p1) -> p.get("age").compareTo(p1.get("age")));
//		System.out.println("��ʱ"+(System.currentTimeMillis()-time));  
//		175ms
		datas.forEach(System.out::println);
		
//		2.����stream������������,��ѭ�����
//		List<Map<String,String>> list = datas.stream()
//		.filter(p -> Integer.valueOf(p.get("age")) <= 18)
//		.limit(5)
//		.forEach(p -> System.out.printf("%s %s", p.get("name"),p.get("age")))
//		.collect(Collectors.toList());
//		list.forEach(System.out::println);
		
//		3.����sorted��������ѭ�����
//		long time1 = System.currentTimeMillis();  
//		datas.stream()
//		.limit(3) //����limit��ָ�����������ֵ
//		.sorted((p, p2) -> (Integer.valueOf(p.get("age"))) - (Integer.valueOf(p.get("age"))))
//		.forEach(p -> System.out.printf("%s %s", p.get("name"),p.get("age")));
//		System.out.println("��ʱ"+(System.currentTimeMillis()-time1));  
		//241ms
		
//		4.��ȡlist��������������ѧ��
//		Map<String,String> maxMap = datas.stream()
//		.max((p,p2) -> Integer.valueOf(p.get("age")) - Integer.valueOf(p2.get("age")))
//		.get();
//		System.out.println("�����͵�ͬѧ�ǣ�["+maxMap.get("name")+"],����Ϊ��["+maxMap.get("age")+"]");
		
//		5.��ȡlist������������С��ѧ��
//		Map<String,String> maxMap = datas.stream()
//		.min((p,p2) -> Integer.parseInt(p.get("age")) - Integer.valueOf(p2.get("age")))
//		.get();
//		System.out.println("��С��͵�ͬѧ�ǣ�["+maxMap.get("name")+"],����Ϊ��["+maxMap.get("age")+"]");
		
//		6.��������ѧ������֮��
//		int totalAge = 
//		datas.parallelStream()  
//		.mapToInt(p -> Integer.parseInt(p.get("age")))  
//		.sum();  
//		System.out.println("����ѧ��������֮��Ϊ:" + totalAge);
		
//		7.Mapѭ��
//		map1.forEach((k,v) -> System.out.println(k+" : "+v));
	}
	
	/**
	 * @Title: summaryStatistics 
	 * @Description: ���stream ��Ԫ�صĸ��ֻ�������
	 * @Author: Gavin
	 * @Create Date: 2017��8��28������12:05:58
	 */
	public static void summaryStatistics(){
		//���� count, min, max, sum, and average for numbers  
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  
		IntSummaryStatistics stats = numbers  
		          .stream()  
		          .mapToInt((x) -> x)  
		          .summaryStatistics();  
		System.out.println("List���������� : " + stats.getMax());  
		System.out.println("List����С������ : " + stats.getMin());  
		System.out.println("�������ֵ��ܺ�   : " + stats.getSum());  
		System.out.println("�������ֵ�ƽ��ֵ : " + stats.getAverage());  
	}
	public static void main(String[] args) {
		
//		�ӿڿ��Զ��徲̬����
//		InterfaceTest.staticmethod();
		
//		jdk1.8֮ǰ�����򷽷�(��ʱ3ms)
//		sortList();
		
//		jdk1.8������(��ʱ220ms)
//		sortListNew();
		
//		����ѭ�����
//		forEachStrings();
		
//		list��������
//		sortListBeans();
		
//	    list��map����
		sortListMaps();
		
//		���stream ��Ԫ�صĸ��ֻ�������
//		summaryStatistics();
	}
}
