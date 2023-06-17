package com.edu.test;

import com.edu.util.MyDate;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secratary;

/*
 * 1.객체 생성 == 클래스의 멤버를 메모리에 올린다.
 * 2.접근
 *   1) 필드에 접근---> 값할당
 *   2) 메소드에 접근 --> 호출
 */
/*
 * Employee타입의 배열을 생성
 * 이 안에 여러 명의 Manager, Engineer, Secratary 객체를 넣고
 * 부모 타입으로 단일하게 이기종간의 객체들을 핸들링할 수 있는 코드를 작성
 * ::
 * Heterogeneous Collection(상속 덕분)
 * 
 */
public class EmployeeAppTest3 {
	public static void main(String[] args) {
		Employee[] emps = { new Manager("James", new MyDate(1990, 3, 24), 200002.0, "IT"),
				new Engineer("EEE", new MyDate(2000, 1, 2), 34000.0, "JAVA", 200),
				new Manager("TOM", new MyDate(1980, 3, 24), 55502.0, "Python"),
				new Secratary("SSS", new MyDate(1985, 11, 17), 40000.0, "James"),
				new Manager("Andy", new MyDate(1993, 3, 24), 55502.0, "Python"), };

		System.out.println("========== 정보를 출력합니다.=================");
		for (Employee e : emps)
			System.out.println(e.getDetails());

		System.out.println("\n========== 연봉 정보를 출력합니다.=================");
		for (Employee e : emps) {
			if (e instanceof Engineer) { // Employee타입으로 생성된 객체가 Manager라면
				Engineer eg = (Engineer) e;
				System.out.println(e.getName() + " 님의 연봉은 " + (e.getSalary() * 12 + eg.getBonus()) + " 달러입니다.");
			} else if (e instanceof Secratary) { // Employee타입으로 생성된 객체가 Secratary라면
				System.out.println(e.getName() + " 님의 연봉은 " + e.getSalary() * 12 + " 달러입니다.");
			} else {
				System.out.println(e.getName() + " 님의 연봉은 " + e.getSalary() * 12 + " 달러입니다.");
			}
		}

		System.out.println("\n========== 각 직원의 이름 정보를 출력합니다.=================");
		for (Employee e : emps)
			System.out.println("Employee Name : " + e.getName());

	}
}