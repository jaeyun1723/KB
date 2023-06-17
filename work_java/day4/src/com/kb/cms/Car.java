package com.kb.cms;

public abstract class Car {

	String num;
	int price;

	public abstract void drive();

	public void drive(int speed) {
	//	System.out.println("시속 " + speed + "km로 달립니다.");
		System.out.printf("시속 %dkm로 달립니다.\n", speed);
	}

	@Override
	public String toString() {
		return "Car [num=" + num + ", price=" + price + "]";
	}
	
	
}
