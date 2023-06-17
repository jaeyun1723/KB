package com.kb.cms2;

import java.util.ArrayList;

public class CarManager {
	ArrayList<Car> cars = new ArrayList<>();

	// List<Car> cars= new ArrayList<Car>();
	public void save(Car c) {
		cars.add(c);
	}

	public void search() {
//		for(int i=0;i<cars.size();i++)
//			System.out.println(cars.get(i));
		for (Car c : cars)
			System.out.println(c);
	}

	public Car search(String num) {
		for (Car c : cars)
			if (c.num.equals(num))
				return c;
		return null;
	}
	
	public void delete(String num) {
		for(Car c : cars)
			if(c.num.equals(num))
				cars.remove(c);
	}

	@Override
	public String toString() {
		return "CarManager [cars=" + cars + "]";
	}
	
	
}
