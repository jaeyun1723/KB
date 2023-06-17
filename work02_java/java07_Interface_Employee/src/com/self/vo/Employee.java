package com.self.vo;

import com.self.util.MyDate;

public class Employee {
	private String name;
	private MyDate birthDate;
	private double salary;
	
	public static final double BASIC_SALARY = 100.0;
	
	public Employee() {}
	
	public Employee(String name, MyDate birthDate, double salary) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}
	
	public Employee(String name, MyDate birthDate) {
		this(name, birthDate, BASIC_SALARY);
	}
		
	public String getName() {
		return name;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	public double getSalary() {
		return salary;
	}

	public static double getBasicSalary() {
		return BASIC_SALARY;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return name+","+birthDate+","+salary;
	}
	
	
}
