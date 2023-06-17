package com.air.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.air.dto.AirLine;
import com.air.dto.Customer;
import com.air.dto.Reservation;
import com.air.exception.DuplicateIDException;
import com.air.exception.RecordNotFoundException;

public interface ReservationDAO {
	Connection getConnect() throws SQLException;

	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;

	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;

	// 비지니스 로직...CRUD
	// 예약 하기
	void reserveAirLine(AirLine air, Customer cust, String grade, String seatId)
			throws SQLException, RecordNotFoundException;

	// 예약 조회
	ArrayList<Reservation> checkAirLine(String custName, String phone) throws SQLException, DuplicateIDException;

	// 예약 취소
	void cancelAirLine(String custName, String phone) throws SQLException, RecordNotFoundException;

}
