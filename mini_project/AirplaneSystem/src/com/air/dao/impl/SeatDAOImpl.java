package com.air.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.air.dao.SeatDAO;
import com.air.dto.Seat;
import com.air.exception.RecordNotFoundException;

public class SeatDAOImpl implements SeatDAO {

	private static SeatDAOImpl seatDao = new SeatDAOImpl();
	private SeatDAOImpl() {}
	public static SeatDAOImpl getInstance() {
		return seatDao;
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
	@Override
	public void insertSeat(Seat seat) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteSeat(String airId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
