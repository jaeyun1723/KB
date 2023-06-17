package com.air.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.air.dto.Customer;
import com.air.dto.Reservation;
import com.air.exception.DuplicateIDException;
import com.air.exception.RecordNotFoundException;

public interface CustomerDAO {
	Connection getConnect() throws SQLException;

	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;

	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;

	// 비지니스 로직...CRUD
	void insertCustomer(Customer cust) throws SQLException, DuplicateIDException;

	// 고객id로 지우기
	void deleteCustomer(int custId) throws SQLException, RecordNotFoundException;

	
	void updateCustomer(Customer cust) throws SQLException, RecordNotFoundException;

	// 고객 개인정보 조회
	Customer getCustomer(String custName, String phone) throws SQLException;

	// 고객 개인예약정보 조회
	ArrayList<Reservation> getAllReserve(Customer cust) throws SQLException;

	// 비지니스 로직...특화된 로직
	void forVIP() throws SQLException;
}