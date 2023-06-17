package com.edu.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest3 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("F");
		list.add("B");
		list.add("B");
		list.add("F");
		list.add("C");

		System.out.println(list);
		// 1. B를 삭제
		System.out.println(list.remove(1) + " 데이터 삭제 성공");
		System.out.println(list);
		
		// 2. B를 다른 방법으로 삭제
		list.remove("B");
		System.out.println(list);

		// 3. 맨 처음에 HH를 추가
		list.add(0, "HH");
		System.out.println(list);
		
		// 4. 3번째 데이터 출력
		System.out.println(list.get(2));
	}

}
