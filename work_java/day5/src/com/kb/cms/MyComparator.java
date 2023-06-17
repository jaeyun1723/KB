package com.kb.cms;

import java.util.Comparator;

public class MyComparator implements Comparator<Customer> {

	String base;

	public MyComparator(String base) {
		this.base = base;
	}

	@Override
	public int compare(Customer o1, Customer o2) {
		if (base.equals("고객번호")) {
			return o1.num - o2.num;
		} else if (base.equals("주소"))
			return o1.address.compareTo(o2.address);
		else
			return o1.name.compareTo(o2.name);
	}

}
