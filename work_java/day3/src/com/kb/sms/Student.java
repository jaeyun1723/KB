package com.kb.sms;

public class Student {
	int num;
	String name;
	
	public Student() {}
	
	public Student(int num, String name) {
		this.num=num;
		this.name=name;
	}
	
	static void study() {
		System.out.println("공부 중...");
	}
	
	void work(int time) {
		System.out.println(time + "시간동안 알바 중..");
	}
}
