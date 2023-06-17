package com.kb.day3;

public class MyDate {
	int year;
	int month;
	int day;
	
	public MyDate() {}
	public MyDate(int y, int m, int d) {
		this.year=y;
		month=m;
		day=d;
	}
	public MyDate(int m, int d) {
		year=2023;
		month=m;
		day=d;
	}
	
	public String toString() {
		return year + "년 " + month + "월 " + day + "일";
	}
}
