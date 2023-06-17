package day4;

import java.util.ArrayList;
import java.util.Collections;

class Person implements Comparable<Person> {
	int age, money;

	public Person(int age, int money) {
		super();
		this.age = age;
		this.money = money;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [age=");
		builder.append(age);
		builder.append(", money=");
		builder.append(money);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Person o) {
//		if (this.money > o.money)
//			return 1;
//		else if (this.money < o.money)
//			return -1;
//		else
//			return 0;
		
//		if (this.money != o.money)
//			return this.money - o.money;
//		else
//			return this.age - o.age;

		return this.money != o.money ? this.money - o.money : this.age - o.age;
	}

}

public class UserSort1 {

	public static void main(String[] args) {
		ArrayList<Person> arr = new ArrayList<>();
		arr.add(new Person(25, 100));
		arr.add(new Person(23, 500));
		arr.add(new Person(20, 400));
		arr.add(new Person(21, 400));
		System.out.println(arr.toString());
		Collections.sort(arr);
		System.out.println(arr.toString());
	}

}
