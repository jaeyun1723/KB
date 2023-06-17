package com.kb.lang;

public class StringTest {
	public static void main(String[] args) {
		String s = new String("IT's your life");
		String s1 = new String("ABC ");
		String s2 = "ABC ";
		String s4 = "ABE ";
		String s3 = s2 + s;
		System.out.println(s3);
		System.out.println(s3.length());
		System.out.println(s3.toLowerCase());
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s2.compareTo(s4));
		System.out.println(s.indexOf("your"));
		System.out.println(s.substring(3, 8));
		System.out.println(s2 + 10 + 30);
		System.out.println(30 + s2 + 10);
		System.out.println(30 + 10 + s2);
		char ch = 'A';
		System.out.println(ch+1);
		System.out.println(++ch);
		System.out.println(s2.trim());	// 여백 제거
	}// em
}// ec
