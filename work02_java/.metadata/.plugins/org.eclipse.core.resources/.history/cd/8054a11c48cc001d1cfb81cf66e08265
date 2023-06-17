package com.edu.vo;

import com.edu.util.MyDate;
//부모 클래스, Super class, Parent Class
public class Employee {
	//필드를 하나 추가
	private int empId;
	private String name;
	private MyDate birthdate;
	private double salary;
	
	//상수값
	public static final double BASIC_SALARY = 100;
	
	public Employee() {}
	public Employee(int empId,String name, MyDate birthdate, double salary) {
		super();
		//필드 초기화
		this.empId = empId;
		this.name = name;
		this.birthdate = birthdate;
		this.salary = salary;
		
	}

	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(MyDate birthdate) {
		this.birthdate = birthdate;
	}

	public double getSalary() {
		return salary;
	}

	public void changeSalary(double salary) {
		this.salary = salary;
	}


	//Object class 의  toString()을 다시 정의
	// 클래스의 필드를 리턴하는 기능을 새롭게 정의할 필요없이
	//toString() 기능을 재정의(Overriding) 해서 사용하도록 하자
	@Override
	public String toString() {
		return empId+","+name+","+birthdate+","+salary;
	}
}
























