package com.self.test;

import com.self.service.EmployeeServiceImpl;
import com.self.util.MyDate;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service 객체를 생성
		EmployeeServiceImpl service =EmployeeServiceImpl.getInstance();
		
		//2. method를 각각 호출..
		System.out.println("============ 1. addEmployee ============ ");
		service.addEmployee(new Manager("AAA", new MyDate(1978, 1, 1), 20000.0, "개발부", 10));
		service.addEmployee(new Engineer("BBB", new MyDate(1995,3,4), 350000.0, "Java", 200.0));
		service.addEmployee(new Manager("CCC", new MyDate(1980, 3, 3), 20000.0, "교육부", 30));
		service.addEmployee(new Manager("DDD", new MyDate(1995, 8, 1), 37000.0, "개발부", 10));
		service.addEmployee(new Engineer("EEE", new MyDate(1995,7,2), 350000.0, "Java", 200.0));
		service.addEmployee(new Engineer("FFF", new MyDate(1994,11,2), 450000.0, "Python", 300.0));
		
		System.out.println("============ Employee 정보확인 ============ ");
		service.printEmployees();

		

		
		System.out.println("\n============ 2. deleteEmployee(BBB 삭제) ============ ");
		service.deleteEmployee("BBB");

		
		System.out.println("============ Employee 정보확인 ============ ");
		service.printEmployees();
		
		System.out.println("\n============ 3. updateEmployee(CCC 부서 수정 교육부->개발부) ============ ");
		service.updateEmployee("CCC", 20000.0, "개발부", 30, "", 0.0);//?

		System.out.println("============ Employee 정보확인 ============ ");
		service.printEmployees();
		
	
		System.out.println("\n============ 4. findMEmployee(AAA) ============ ");
		Employee emp1=service.findEmployee("AAA");
		System.out.println(emp1);
		
		System.out.println("\n============ 4. findMEmployee(10) ============ ");
		System.out.println("30번 부서에 근무하는 직원들 입니다..");
		Employee[ ] emps= service.findEmployee(10);
		for(Employee e : emps) {
			if(e==null) continue;
			System.out.println(e);
		}
	}
}







