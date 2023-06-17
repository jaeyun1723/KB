package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Person2 {
	int age, money;

	public Person2(int age, int money) {
		super();
		this.age = age;
		this.money = money;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person2 [age=");
		builder.append(age);
		builder.append(", money=");
		builder.append(money);
		builder.append("]");
		return builder.toString();
	}

}

public class UserSort2 {

	public static void main(String[] args) {
		ArrayList<Person2> arr = new ArrayList<>();
		arr.add(new Person2(25, 100));
		arr.add(new Person2(20, 500));
		arr.add(new Person2(23, 400));
		arr.add(new Person2(21, 400));
		Collections.sort(arr, (p1, p2) -> p1.money - p2.money);
		Collections.sort(arr, (p1, p2) -> p1.money != p2.money?p1.money-p2.money: p1.age-p2.age);
		System.out.println(arr.toString());
	}//

}//
