package com.air.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface SeatReservationDAO {
	Connection getConnect() throws SQLException;

	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;

	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;

}
