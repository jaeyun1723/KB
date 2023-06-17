package com.kb.cms2;

public class Bus extends Car {
	int seat;

	Bus() {
	}

	Bus(String num, int price, int seat) {
		this.num = num;
		this.price = price;
		this.seat = seat;
	}

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
}
