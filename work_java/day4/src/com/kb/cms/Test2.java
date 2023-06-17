package com.kb.cms;

public class Test2 {

	public static void main(String[] args) {
	//	Car c = new Car();
	//	c.drive();
		
		Car b = new Bus();	// 객체의 다형성
		b.drive();			// 메서드의 다형성
		System.out.println(b);
		
		Door d = new Bus();
		d.open();
		d.close();
	} 

}
