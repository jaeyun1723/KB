package com.edu.vo;

import com.edu.util.MyDate;

public class Secratary extends Employee{
		
	private String bossOfName;
	
	public Secratary() {}//기본 생성자
	public Secratary(int empId,String name, MyDate birthdate, double salary, String bossOfName) {
		//
		super(empId,name,birthdate,salary);
		this.bossOfName = bossOfName;
	}
	public String getBossOfName() {
		return bossOfName;
	}
	public void changeBossOfName(String bossOfName) {
		this.bossOfName = bossOfName;
	}	
	
	@Override
	public String toString() {
		return super.toString()+","+bossOfName;
	}	
}










