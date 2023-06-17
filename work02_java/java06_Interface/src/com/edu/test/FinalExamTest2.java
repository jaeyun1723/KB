package com.edu.test;

/*
 * final
 * 
 * <<access modifier>>
 * 		public / protected / private
 * 
 * <<usage modifier>>
 * 		static / abstract / final
 * 		ex) static final int SPEED;
 * 			final static int SPEED;
 * 
 * final 
 * final + 변수 ==> "내가 마지막 변수" - 상수
 * final + 클래스 ==> "내가 마지막 클래스" - 상속금지
 * final + 메소드 ==> "내가 마지막 메소드" - overriding 금지
 */

class A {
	public static final int BASIC_SALARY = 30000000;

	public final String test() {
		return "Overriding 금지";
	}
}

final class SuperA { // 상속금지

}

//class Child extends SuperA{
//	
//}

//class ChildA extends SuperA{	// 상속금지 클래스 상속 받음
////	BASIC_SALARY=100000; // 값 변경 불가
//
//	public final String test() {
//		String name = "james";
//		return "Overriding 금지";
//	}
//}

public class FinalExamTest2 {

	public static void main(String[] args) {

	}

}
