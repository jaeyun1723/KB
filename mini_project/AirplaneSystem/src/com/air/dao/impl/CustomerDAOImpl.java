package com.air.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.air.dao.CustomerDAO;
import com.air.dto.Customer;
import com.air.dto.Reservation;
import com.air.exception.DuplicateIDException;
import com.air.exception.RecordNotFoundException;

import config.ServerInfo;

public class CustomerDAOImpl implements CustomerDAO {
	// 싱글톤패턴
	private static CustomerDAOImpl custDao = new CustomerDAOImpl();

	private CustomerDAOImpl() {
	}

	public static CustomerDAOImpl getInstance() {
		return custDao;
	}

	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Connect...Success");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}

	private boolean isExist(String custName, String phone, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT cust_name, phone FROM customer WHERE cust_name=? and phone=?";
		ps = conn.prepareStatement(query);
		ps.setString(1, custName);
		ps.setString(2, phone);
		rs = ps.executeQuery();
		return rs.next();
	}

	private boolean idExist(int custId, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT cust_id FROM customer WHERE cust_id=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, custId);
		rs = ps.executeQuery();
		return rs.next();
	}

	@Override
	public void insertCustomer(Customer cust) throws SQLException, DuplicateIDException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnect();
			if (!isExist(cust.getCustName(), cust.getPhone(), conn)) {

				String query = "INSERT INTO customer(cust_id, cust_name, phone, birthdate, email, point) VALUES(seq_cust_id.nextVal, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(query);
				ps.setString(1, cust.getCustName());
				ps.setString(2, cust.getPhone());
				ps.setString(3, cust.getBirthdate());
				ps.setString(4, cust.getEmail());
				ps.setDouble(5, cust.getPoint());
				System.out.println(ps.executeUpdate() + " ROW INSERT OK~!!!");
			} else {
				throw new DuplicateIDException("이미 존재하는 고객입니다.");
			}
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void deleteCustomer(int custId) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnect();
			if (idExist(custId, conn)) {

				String query = "DELETE FROM customer WHERE cust_id=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, custId);

				System.out.println(ps.executeUpdate() + " ROW DELETE OK~!!!");
			} else {
				throw new RecordNotFoundException("삭제할 대상고객이 존재하지 않습니다.");
			}
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateCustomer(Customer cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnect();
			if (idExist(cust.getCustId(), conn)) {

				String query = "UPDATE customer SET cust_name=?, phone=?, birthdate=?, email=? WHERE cust_id=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, cust.getCustName());
				ps.setString(2, cust.getPhone());
				ps.setString(3, cust.getBirthdate());
				ps.setString(4, cust.getEmail());
				ps.setInt(5, cust.getCustId());

				System.out.println(ps.executeUpdate() + " ROW UPDATE OK~!!!");
			} else {
				throw new RecordNotFoundException("수정할 고객이 존재하지 않습니다.");
			}
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public Customer getCustomer(String custName, String phone) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer customer = null;

		try {
			conn = getConnect();

			String query = "SELECT cust_id, cust_name, phone, birthdate, email, point FROM customer WHERE cust_name=? and phone=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, custName);
			ps.setString(2, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getInt("cust_id"), custName, phone, rs.getString("birthdate"),
						rs.getString("email"), rs.getDouble("point"));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return customer;
	}

	@Override
	public ArrayList<Reservation> getAllReserve(Customer cust) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Reservation> reserves = new ArrayList<>();

		return reserves;
	}

	@Override
	public void forVIP() throws SQLException {
		// TODO Auto-generated method stub

	}

}
