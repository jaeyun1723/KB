package com.edu.vo;

import com.edu.util.MyDate;
/*
1. private 필드 선언
2. public 값이 주입되는 통로(명시적 생성자, setter)
3. public 주입된 값을 반환하는 기능을 정의

Field : name, birthdate, salary, mainSkill, bonus --> 5
*/

public class Engineer {
	private String name;
	private MyDate birthdate;
	private double salary;
	private String mainSkill;
	private double bonus;

	public Engineer(String name, MyDate birthdaDate, double salary, String mainSKill, double bonus) {
		this.name = name;
		this.birthdate = birthdaDate;
		this.salary = salary;
		this.mainSkill = mainSKill;
		this.bonus = bonus;
	}

	
	public String getName() {
		return name;
	}


	public MyDate getBirthdate() {
		return birthdate;
	}


	public double getSalary() {
		return salary;
	}


	public String getMainSkill() {
		return mainSkill;
	}


	public double getBonus() {
		return bonus;
	}


	public String getDetails() {
		return name + ", " + birthdate.getDate() + ", " + salary + ", " + mainSkill + ", " + bonus;
	}
}
