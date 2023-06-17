package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectTest1 {

	public static void main(String[] args) {
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");// FQCN
			System.out.println("1. Driver Loading...Success...");

			// 2.디비 연결,, 1) 디비 서버 주소 2) 계정 3) 비번
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", 
					"kb_db", "1234");
			// (프로토콜(jdbc:oracle):연결방법:@DB저장될ip주소:포트(oracle디폴트):오라클버전)
			System.out.println("2. DB Connect...Success...");

			// 3. CRUD작업....디비서버와 연결이 이뤄져야만 가능...
			String query = "INSERT INTO custom(id, name, address) VALUES(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			System.out.println("3. PreparedStatement..Creating..");
			
			// ?에 대한 값 바인딩
			ps.setInt(1, 333);
			ps.setString(2, "신사동");
			ps.setString(3, "이정재");

			System.out.println("\n================INSERT===================");
			// 진짜 쿼리문이 실행...excuteUpdate()
			System.out.println(ps.executeUpdate()+"row INSERT OK~~!!");
		} catch (ClassNotFoundException e) {
			System.out.println("1. Driver Loading...Fail...");
		} catch (SQLException e) {
			System.out.println("2. DB Connect...Fail...");
		}

	}//
}//
