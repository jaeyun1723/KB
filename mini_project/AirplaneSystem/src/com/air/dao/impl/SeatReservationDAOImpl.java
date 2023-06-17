package com.air.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.air.dao.SeatReservationDAO;

public class SeatReservationDAOImpl implements SeatReservationDAO {
	private static SeatReservationDAOImpl srDao = new SeatReservationDAOImpl();
	private SeatReservationDAOImpl() {}
	public static SeatReservationDAOImpl getInstance() {
		return srDao;
	}
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
}
