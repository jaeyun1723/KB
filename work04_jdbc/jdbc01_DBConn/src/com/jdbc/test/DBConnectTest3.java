package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*
 * DB연결 프로그램에 서버 정보에 관련된 실제값이 하드코딩 되어져있다.
 * 드라이버, FQCN, 서버 주소, 계정 이름, 비번... 노출되면 안됌. --> Meta Data화 시켜야함
 * -- Meta Data화 = 파일로 분리(xml, properties) - 인터페이스분리
 * 1. 드라이버로딩
 * 2. 디비연결 ------------ Connection
 * 3. Preparedstatement ---------- Preparedstatement/
 * 4. 쿼리문 실행 --------------- ResultSet
 * 5. 자원 반환... close()
 * 		열린 순서 반대로 닫는다.	try~finally
 * 		ResultSet
 * 		Preparedstatement
 * 		Connection
 */
public class DBConnectTest3 {

	public DBConnectTest3() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(ServerInfo.DRIVER_NAME);// FQCN
			conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
			String query = "SELECT id, name, address FROM custom";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new DBConnectTest3();
	}//
}//
