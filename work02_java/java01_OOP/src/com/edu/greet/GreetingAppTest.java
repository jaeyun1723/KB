package com.edu.greet;

public class GreetingAppTest {

	public static void main(String[] args) {

		// 1. 클래스 객체를 생성

		Greeting g = new Greeting();

		g.target = "1반 여러분~~";
		g.message = "반갑습니다~!!!";
		
		System.out.println(g.sayHello());
		
		
	}//

}//
