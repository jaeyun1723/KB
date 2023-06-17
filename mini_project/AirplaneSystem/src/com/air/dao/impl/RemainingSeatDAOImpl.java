package com.air.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.air.dao.CustomerDAO;
import com.air.dao.RemainingSeatDAO;

public class RemainingSeatDAOImpl implements RemainingSeatDAO {

	@Override
	public Connection getConnect() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seatAvailable(String airId, String grade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
