package com.jdbc.test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.dao.CustomerDAOImpl;
import com.jdbc.domain.Customer;
import com.jdbc.exception.RecordNotFoundException;

import config.ServerInfo;

public class CustomerDAOImplTest {

	public static void main(String[] args) {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
//		try {
////			dao.registerCustomer(new Customer("111", "제임스", "보스톤"));
////			dao.registerCustomer(new Customer("444", "제임스", "보스톤"));
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//		}		
		
		
		/*
		try {
			dao.removeCustomer("444");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		*/
		
		/*
		try {
			dao.updateCustomer(new Customer("333", "제임스22", "보스톤22"));
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		*/
		
		try {
			ArrayList<Customer> list = dao.getCustomer();
			for(Customer c : list)System.out.println(c);
		}catch(Exception e) {
			
		}

	}
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading...ok");
		}catch(Exception e) {
			System.out.println("Driver Loading...fail");
		}
	}

}