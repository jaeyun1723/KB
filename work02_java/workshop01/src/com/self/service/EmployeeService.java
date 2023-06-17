package com.self.service;

import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeService {
	Employee[] es;
	static final int SIZE = 10;
	static int eidx;

	private static EmployeeService service = new EmployeeService(SIZE);

	private EmployeeService(int size) {
		es = new Employee[size];
	}

	public static EmployeeService getInstance() {
		return service;
	}

	public static int getEidx() {
		return eidx;
	}

	public static void setEidx(int eidx) {
		EmployeeService.eidx = eidx;
	}

	public void addEmployee(Employee e) {
		es[eidx++] = e;
	}

	public void deleteEmployee(String name) {
		for (int i = 0; i < eidx; i++) {
			if (es[i].getName().equals(name)) {
				for (int j = i; j < eidx; j++)
					es[j] = es[j + 1];
				es[eidx--] = null;
			}
		}
	}

	public void updateManager(double salary, String dept, int deptno, String name) {
		for (Employee e : es) {
			if (e == null)
				continue;
			if (e.getName().equals(name)) {
				((Manager) e).setSalary(salary);
				((Manager) e).setDept(dept);
				((Manager) e).setDeptno(deptno);
			}
		}
	}

	public void updateEngineer(Engineer eg) {
		for (Employee e : es) {
			if (e.getName().equals(eg.getName())) {
				((Engineer) e).setBirthDate(eg.getBirthDate());
				((Engineer) e).setBonus(eg.getBonus());
				((Engineer) e).setSalary(eg.getSalary());
				((Engineer) e).setTech(eg.getTech());
			}
		}
	}

	// Method Overloading
	/*
	 * 하는일은 똑같은데...처리하는 데이타를 달리할때 쓰는 기법 메소드의 통일감을 강조하면서도 서로다른 데이타를 처리할수 있게끔 해준다.
	 */
	public Employee findEmployee(String name) {
		Employee employee = null;
		for (Employee e : es) {
			if (e == null)
				continue;
			if (e.getName().equals(name)) {
				employee = e;
				break;
			}
		}
		return employee;
	}

	public Manager[] findManager(int deptno) {
		Manager[] temp = new Manager[SIZE];
		int count = 0;
		for (Employee e : es) {
			if (e == null)
				continue;
			if (e instanceof Manager && ((Manager) e).getDeptno() == deptno) {
				temp[count++] = (Manager) e;
			}
		}
		return temp;
	}

	// 추가
	public void printEmployee() {
		for (Employee e : es) {
			if (e != null) {
				if (e instanceof Manager)
					System.out.println(((Manager) e).toString());
				if (e instanceof Engineer)
					System.out.println(((Engineer) e).toString());
			}
		}
	}

}
