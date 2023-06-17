package com.kb.day3;

public class Test5 {

	public static void main(String[] args) {
		MyDate[] md = new MyDate[5];
		md[0] = new MyDate(3, 23);
		md[1] = new MyDate(4, 21);
		md[2] = new MyDate(5, 5);
		md[3] = new MyDate(5, 15);
		md[4] = new MyDate(5, 29);

		MyDate m = md[2];
		// System.out.println(m);
		// System.out.println(md[1]);
		for (MyDate ss : md)
			System.out.println(ss);
		System.out.println();
		for (MyDate ss : md)
			if (ss.month == 5)
				System.out.println(ss);
	}// em

}// ec
