package com.air.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.air.dto.Seat;

public interface SeatDAO {
	Connection getConnect() throws SQLException;

	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;

	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;

	void insertSeat(Seat seat) throws SQLException;	// 항공편 insert시 항공편 좌석 자동 추가

	void deleteSeat(String airId) throws SQLException;	// 항공편 delete시 항공편 좌석 자동 삭제

}
