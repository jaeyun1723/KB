package com.edu.vo;

import com.edu.util.MyDate;

//부모 클래스, Super class, Parent Class
public class Employee {

	private String name;
	private MyDate birthdate;
	private double salary;

	public static final double BASIC_SALARY = 100;
	public Employee(String name, MyDate birthdate, double salary) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.salary = salary;
	}

	
	/*
	 * this 
	 * 1) local V와 field의 이름이 동일할때 구분하기 위해서 필드 앞에 붙인다. 
	 * 2) this()--> 하나의 클래스에서 또 다른 생성자를 호출할 때 사용함
	 */
	
	public Employee(String name, MyDate birthDate) {
		this(name, birthDate, BASIC_SALARY);
	}

	public Employee() {}
	
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

	public String getDetails() {
		return name + "," + birthdate.getDate() + "," + salary;
	}

}