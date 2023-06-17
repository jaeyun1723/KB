package com.kb.cms;

public class Customer extends Object implements Comparable<Customer> {

	int num;
	String name;
	String address;

	public Customer() {
		// super();
	}

	public Customer(int num, String name, String address) {
		super(); // super의 생성자 호출
		this.num = num;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [num=");
		builder.append(num);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Customer o) {
		// 고객 번호로 sort
		// return this.num-o.num;
		return this.name.compareTo(o.name);
	}

}
