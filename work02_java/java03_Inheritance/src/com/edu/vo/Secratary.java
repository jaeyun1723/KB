package com.edu.vo;

import com.edu.util.MyDate;

public class Secratary extends Employee{
		
	private String bossOfName;
	
	public Secratary() {}//기본 생성자
	public Secratary(String name, MyDate birthdate, double salary, String bossOfName) {
		//
		super(name,birthdate,salary);
		this.bossOfName = bossOfName;
	}
	public String getBossOfName() {
		return bossOfName;
	}
	public void changeBossOfName(String bossOfName) {
		this.bossOfName = bossOfName;
	}	
	public String getDetails() {
		return super.getDetails() + "," + bossOfName;
	}
}