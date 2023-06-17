package com.self.vo;

import com.self.util.MyDate;

public class Manager extends Employee{
	
	private String dept;
	private int deptno;
	public Manager(String name, MyDate birthDate, double salary, String dept, int deptno) {
		super(name, birthDate, salary);	
		this.dept = dept;
		this.deptno = deptno;
	}	
	
	public void changeDept(String dept) {
		this.dept = dept;
	}
	public void changeDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
	public String getDept() {
		return dept;
	}
	public int getDeptno() {
		return deptno;
	}
	
	@Override
	public String toString() {
		return super.toString()+","+deptno+","+dept;
	}
}






