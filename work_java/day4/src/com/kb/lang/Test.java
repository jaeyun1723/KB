package com.kb.lang;

public class Test {
	
	public static void main(String[] args) {
		
		int[] su=new int[3];
		String s1=new String("ABC");
		String s2=new String("ABC");
		String s3="ABC";
		String s4="ABC";
		
		System.out.println(s1==s2);	// false
		System.out.println(s1.equals(s2));	//true
		System.out.println(s3==s4);	//true
		
	}//em

}//ec
