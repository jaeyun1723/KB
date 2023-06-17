package com.edu.test;

import com.edu.util.MyDate;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secratary;
/*
 * Manager타입의 배열을 생성
 * 이 안에 여러명의 Manager객체를 넣고
 * 한번에 핸들링할 수 있는 코드를 작성
 */
public class EmployeeAppTest2 {
	public static void main(String[] args) {	
		Manager[ ] managers=  {
				new Manager("James", new MyDate(1990,3,24),200002.0,"IT"),
				new Manager("Gosling", new MyDate(1990,2,24),150002.0,"Maketing"),
				new Manager("Peter", new MyDate(1990,1,24),450002.0,"IT")
				
		};

		System.out.println("========== 정보를 출력합니다.=================");			
	//	for(Manager m : managers) System.out.println(m.getDetails());
		
		System.out.println("\n========== 연봉 정보를 출력합니다.=================");
		for(Manager m : managers) System.out.println(m.getSalary() * 12+" 달러");
		
		System.out.println("\n========== 각 직원의 이름 정보를 출력합니다.=================");
		for(Manager m : managers) System.out.println("Manager Name :"+m.getName());	
				
				
				
		
		


	}
}