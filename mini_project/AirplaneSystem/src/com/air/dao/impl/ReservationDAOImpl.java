package com.air.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.air.dao.ReservationDAO;
import com.air.dto.AirLine;
import com.air.dto.Customer;
import com.air.dto.Reservation;
import com.air.exception.DuplicateIDException;
import com.air.exception.RecordNotFoundException;

import config.ServerInfo;

public class ReservationDAOImpl implements ReservationDAO {

	private static ReservationDAOImpl resDao = new ReservationDAOImpl();

	private ReservationDAOImpl() {
	}

	public static ReservationDAOImpl getInstance() {
		return resDao;
	}

	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Connection....OK");
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

	private static double isFee(String grade) {
		if (grade.equals("일반석"))
			return 1;
		if (grade.equals("비즈니스석"))
			return 1.5;
		if (grade.equals("일등석"))
			return 2;
		else
			return 0;
	}

	@Override
	public void reserveAirLine(AirLine air, Customer cust, String grade, String seatId)
			throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			// 1. 예약 테이블에 insert
			String query = "INSERT INTO reservation VALUES (seq_res_id.NEXTVAL,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, cust.getCustId());
			ps.setString(2, air.getAirId());
			ps.setString(3, grade);
			ps.setInt(4, air.getTotPrice());
			System.out.println(ps.executeUpdate() + " [INSERT] SUCCESS");
			// 2. 회원에 예약 이력 저장
			query = "SELECT seq_res_id.currval FROM dual";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			int rid = 0;
			while (rs.next()) {
				rid = rs.getInt(1); // res_id
			}
			int fee = (int) (air.getTotPrice() / air.getSeats() * isFee(grade)); // 운행요금->고객 비용산정
			ArrayList<Reservation> list = new ArrayList<>(); // 현재 고객의 예약 리스트
			list = cust.getResList();
			list.add(new Reservation(rid, cust.getCustId(), air.getAirId(), grade, fee)); // 리스트에 추가
			cust.setResList(list); // 고객 정보 갱신
			// 3. 좌석->좌석상태 바꿔야함
			query = "UPDATE seat SET seat_status=? WHERE seat_id=? AND air_id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, "예약불가");
			ps.setString(2, seatId);
			ps.setString(3, air.getAirId());
			System.out.println(ps.executeUpdate() + " [좌석 테이블] UPDATE OK~!!!");
			// 4. 좌석예약 테이블에 좌석번호,예약번호 insert
			query = "INSERT INTO res_seat VALUES (?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, seatId);
			ps.setString(2, air.getAirId());
			System.out.println(ps.executeUpdate() + " [ 좌석 예약 테이블 ] INSERT SUCCESS");
		} finally {
			closeAll(ps, conn);
		}

	}

	@Override
	public ArrayList<Reservation> checkAirLine(String custName, String phone)
			throws SQLException, DuplicateIDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelAirLine(String custName, String phone) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub

	}

}
