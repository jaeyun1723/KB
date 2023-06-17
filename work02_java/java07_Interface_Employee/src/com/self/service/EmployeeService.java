package com.self.service;

import com.self.vo.Employee;

public interface EmployeeService {
	void addEmployee(Employee e);

	void deleteEmployee(String name);

	void updateEmployee(String name, double salary, 
			String dept, int deptno, String tech, double bonus);

	Employee findEmployee(String name);

	Employee[] findEmployee(int deptno);

	void printEmployees();
}
