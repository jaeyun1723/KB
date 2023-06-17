package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.domain.Customer;
import com.jdbc.exception.DuplicateSSNException;
import com.jdbc.exception.RecordNotFoundException;

import config.ServerInfo;

public class CustomerDAOImpl implements CustomerDAO{
	
	private static CustomerDAOImpl dao = new CustomerDAOImpl();
	private CustomerDAOImpl() {
		
	}
	public static CustomerDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn=DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Connection....OK");
		return conn;
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps!=null)ps.close();
		if(conn!=null)conn.close();		
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs!=null)rs.close();
		closeAll(conn, ps);
		
	}
	
	private boolean ssnExist(String ssn, Connection conn)throws SQLException{
				
		PreparedStatement ps = null;
		ResultSet rs = null;		
	
		String query = "SELECT ssn FROM customer WHERE ssn=?";
		ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		rs = ps.executeQuery();
		return rs.next();
		
	}
	@Override
	public void registerCustomer(Customer vo) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(!ssnExist(vo.getSsn(), conn)) {//ssn이 없다면			
			
			String query = "INSERT INTO customer(ssn, name, address)VALUES(?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getSsn());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getAddress());
			
			System.out.println(ps.executeUpdate()+" row INSERT OK~~!!");
			}else { //ssn이 있다면
				throw new DuplicateSSNException("이미 존재하는 고객입니다.");
			}
		}finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public void removeCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(ssnExist(ssn, conn)) { //삭제할 대상이 있다면
				String query = "DELETE customer WHERE ssn=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);
				System.out.println(ps.executeUpdate()+" row DELETE OK");
			}else {
				throw new RecordNotFoundException("삭제할 고객이 존재하지 않습니다.");
			}
		}finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
	public void updateCustomer(Customer vo) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(ssnExist(vo.getSsn(), conn)) { //수정할 대상이 있다면
				String query = "UPDATE customer SET name=?, address=? WHERE ssn=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getAddress());
				ps.setString(3, vo.getSsn());
				System.out.println(ps.executeUpdate()+" row UPDATE OK");
			}else {
				throw new RecordNotFoundException("수정할 고객이 존재하지 않습니다.");
			}
		}finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
	public Customer getCustomer(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer customer = null;
		try {
			conn = getConnect();
			String query = "SELECT ssn, name, address FROM customer WHERE ssn=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			if(rs.next()) {
				customer = new Customer(ssn, 
										rs.getString("name"), 
										rs.getString("address"));
			}
		}finally {
			closeAll(conn, ps, rs);
		}
		return customer;
	}

	@Override
	public ArrayList<Customer> getCustomer() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Customer> customers = new ArrayList<>();
		try {
			conn = getConnect();
			String query = "SELECT ssn, name, address FROM customer";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				customers.add(new Customer(rs.getString("ssn"), 
										   rs.getString("name"), 
										   rs.getString("address")));
			}
		}finally {
			closeAll(conn, ps, rs);
		}
		return customers;
	}

}