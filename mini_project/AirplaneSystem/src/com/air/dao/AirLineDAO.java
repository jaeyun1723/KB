package com.air.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.air.dto.AirLine;
import com.air.dto.Customer;
import com.air.dto.Reservation;
import com.air.exception.DuplicateAirLineException;
import com.air.exception.DuplicateIDException;
import com.air.exception.RecordNotFoundException;

public interface AirLineDAO {

	Connection getConnect() throws SQLException;

	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;

	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;

	// 비지니스 로직...CRUD

	void insertAirLine(AirLine airline) throws SQLException, DuplicateAirLineException;

	void deleteAirLine(String airId) throws SQLException, RecordNotFoundException;

	// 항공편 조회
	ArrayList<AirLine> searchAirLine(String depart, String arrival, double grade)
			throws SQLException, DuplicateIDException;

	ArrayList<AirLine> searchAirLine(String dptTime, double grade) throws SQLException, DuplicateIDException;

	ArrayList<AirLine> searchAirLine(double grade, int totPrice) throws SQLException, DuplicateIDException;

}
