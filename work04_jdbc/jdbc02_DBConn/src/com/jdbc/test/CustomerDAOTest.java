package com.jdbc.test;

import java.sql.SQLException;

import com.jdbc.dao.CustomerDAO;

import config.ServerInfo;

/*
 * 1. CustomerDAO객체 생성(==메모리에 올린다)
 * 2. CustomerDAO의 기능을 호출
 */
public class CustomerDAOTest {

	public static void main(String[] args) throws SQLException {
		System.out.println("a");
		CustomerDAO dao = new CustomerDAO();
//		dao.addCustomer("333", "전도연1", "서초동1");
//		dao.removeCustomer("333");
//		dao.updateCustomer("222", "전도연", "방배동");
	}

	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading....");
		} catch(ClassNotFoundException e) {
			System.out.println("Driver Fail....");
		}
	}
	
	
}//
