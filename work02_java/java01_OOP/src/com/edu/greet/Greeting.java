package com.edu.greet;

//특정한 대상에게
//다양한 인삿말을 출력하는 정보를 가지는 클래스
//OOP....Object

public class Greeting {

	String target;
	String message;

	public String sayHello() {
		return target + ", " + message + "~~!!";
	}

}//
