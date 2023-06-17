package com.kb.lang;

public class StringBuilderTest {

	public static void main(String[] args) {
		String s1= new String("Hello");
		String s2="Hello";
		s2=s1+s2;
		System.out.println(s2);
		
		StringBuilder sb=new StringBuilder("ABC");
		System.out.println(sb);
		sb.append("DEF");
		System.out.println(sb);
		sb.append(true);
		System.out.println(sb);
		System.out.println(sb.charAt(2));
		System.out.println(sb.length());
		sb.setLength(4);
		System.out.println(sb);
		System.out.println(sb.reverse());
		System.out.println(sb);
		String res=sb.toString();		
		System.out.println(res);
	}//em

}//ec
