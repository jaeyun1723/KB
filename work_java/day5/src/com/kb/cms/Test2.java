package com.kb.cms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test2 {

//	static int cnt=0;
//	
//	Test2(){
//		cnt++;
//	}
	public static void main(String[] args) {
		
		  List<String> ss = new ArrayList<>(); ss.add("Kim"); ss.add("Lee");
		  ss.add("Kang"); ss.add("Bae");
		  
		  Collections.sort(ss);
		  for(String s : ss) System.out.println(s);
		  
		  System.out.println("======");
		  
		  String[] s2= {"Kim","Lee","Kang","Bae"}; Arrays.sort(s2);
		  
		  for(String s : s2) System.out.println(s);
		  System.out.println(Arrays.toString(s2));
		 
		/*
		 * Test2 t= new Test2(); Test2 t2= new Test2(); Test2 t3= new Test2(); Test2 t4=
		 * new Test2(); Test2 t5= new Test2(); System.out.println(t3.cnt);
		 */
		  
		  List<Integer> s=new ArrayList<>();
		  s.add(1);
		  s.add(2);
		  s.add(3);
		  s.add(4);
		 // s.remove(2);
		  int sss=3;
		  s.remove(3);
		  System.out.println(s.toString());
	}//etc

}//etc
