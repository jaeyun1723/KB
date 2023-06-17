package com.edu.service;

import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;

// 싱글톤 패턴으로 작성
public class EmployeeService {
	//1
	private static EmployeeService service = new EmployeeService();

	//2
	private EmployeeService() {
		System.out.println("Only One");
	}

	//3
	public static EmployeeService getInstance() {
		return service;
	}

	public void printAllEmployee(Employee[] ea) {
		for (Employee e : ea)
			System.out.println(e);
	}

	public Employee findEmployee(Employee[] ea, int empId) {
		Employee employee = null;
		for (Employee e : ea) {
			if (e.getEmpId() == empId) {
				employee = e;
				break;
			}
		}
		return employee;
	}

	public Employee[] findEmployee(Employee[] ea, String dept) {
		Employee[] temp = new Employee[ea.length];
		int idx = 0;
		for (Employee e : ea) {
			if (e instanceof Manager) {
				if (((Manager) e).getDept().equals(dept))
					temp[idx++] = e;
			}
		}
		return temp;
	}

	public int getAnnualSalary(Employee e) {
		int annualSalary = 0;
		annualSalary = (int) (e.getSalary() * 12);
		if (e instanceof Engineer)
			annualSalary = (int) (e.getSalary() * 12 + ((Engineer) e).getBonus());
		return annualSalary;
	}

	public int getTotalCost(Employee[] ea) {
		int totalCost = 0;
		for (Employee e : ea)
			totalCost += getAnnualSalary(e);
		return totalCost;

	}
}
