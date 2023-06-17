package com.kb.cms;

public class Bus extends Car implements Door {
	int seat;

	public void autoDoor(boolean flag) {
		if (flag)
			System.out.println("Open Door" + price);
		else
			System.out.println("Close Door");
	}

	public void drive() {
		System.out.println("시속 80km로 달립니다.");
	}

	@Override
	public String toString() {
		return "Bus 번호: " + num + ", 가격: " + price + " 좌석: " + seat;
	}

	@Override
	public void open() {
		System.out.println("문 열림");
	}

	@Override
	public void close() {
		System.out.println("문 닫음");
	}

}
