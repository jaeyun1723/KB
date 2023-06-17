package com.self.service;

import com.self.vo.Engineer;
import com.self.vo.Manager;
import com.self.vo.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private static EmployeeServiceImpl service = new EmployeeServiceImpl(10);
	
//	Manager[ ] ms;
//	int midx;
//	
//	Engineer[ ] egs;
//	int egidx;	
	
	Employee[ ] employees;
	int idx = 0;

	private EmployeeServiceImpl(int size){
		employees = new Employee[size];
	}
	
	public static EmployeeServiceImpl getInstance() {
		return service;
	}
	
	public void addEmployee(Employee e) {	
		employees[idx++] = e;
		System.out.println(e.getName()+" 님이 등록되셨습니다~~!");
	}
	
	public void deleteEmployee(String name) {	
		for(int i=0; i<idx; i++) {
			if(employees[i].getName().equals(name)) {
				for(int j=i; j<idx; j++) {
					employees[j] = employees[j+1];
				}
				employees[idx] = null;
				idx--;
			}
		}
		System.out.println(name+" 님이 탈퇴처리 되었습니다.~~!!");
	}
	
	public void updateEmployee(String name, double salary, String dept, int deptno, String tech, double bonus) {
		for(Employee e : employees) {	
			if(e==null) continue;
			if(e.getName().equals(name)) {
				e.setSalary(salary);
				if(e instanceof Manager) {
					((Manager) e).changeDept(dept);
					((Manager) e).changeDeptno(deptno);
				}
				if(e instanceof Engineer) {
					((Engineer) e).changeTech(tech);
					((Engineer) e).changeBonus(bonus);
				}			
			}			
		}
	}
	
	public Employee findEmployee(String name) {
		Employee e = null;
		for(Employee emp : employees) {
			if(emp==null)continue;
			if(emp.getName().equals(name))
				e = emp;
		}
		
		return e;
	}
	public Employee[] findEmployee(int deptno) {
		Employee[ ] temp= new Employee[10];
		int count = 0;
		for(Employee emp : employees) {
			if(emp==null) continue;
			if(emp instanceof Manager) {
				if(((Manager) emp).getDeptno()== deptno)
					temp[count++] = emp;
			}			
		}
		
		return temp;
	}
		
	public void printEmployees() {		
		for(Employee emp : employees) {
			if(emp==null) continue;
		System.out.println(emp);
		}
	}
	
}














