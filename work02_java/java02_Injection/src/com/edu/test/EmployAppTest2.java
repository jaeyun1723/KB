package com.edu.test;

import com.edu.util.MyDate;
import com.edu.vo.*;

/*
 * Manager타입의 배열을 생성
 * 이 안의 여러명의 Manager객체를 넣고
 * 한 번에 핸들링할 수 있는 코드를 작성
 */
public class EmployAppTest2 {

	public static void main(String[] args) {
		Manager[] managers = { new Manager("James", new MyDate(1990, 3, 24), 200002.0, "IT"),
				new Manager("asd", new MyDate(1991, 6, 24), 210002.0, "CS"),
				new Manager("fs", new MyDate(1992, 4, 24), 222002.0, "IT") };

		System.out.println("========== 정보를 출력합니다.=================");
		for (Manager mg : managers)
			System.out.println(mg.getDetails());

		System.out.println("========== 연봉 정보를 출력합니다.=================");
		for (Manager mg : managers)
			System.out.println(mg.getSalary() * 12 + "달러");

		System.out.println("\n========== 각 직원의 이름 정보를 출력합니다.=================");
		for (Manager mg : managers)
			System.out.println("Manager Name :" + mg.getName());

	}

}
