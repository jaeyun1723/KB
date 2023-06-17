package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;


public class TXBankDAO {

	private static TXBankDAO dao = new TXBankDAO();
	private TXBankDAO() {}
	public static TXBankDAO getInstance() {
		return dao;
	}

	////////////////   Connection 반환  ////////////////////////////////////////
	
	public Connection getConnect() throws SQLException {
		Connection conn=DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Server Connection......");
		return conn;
	}	

	
	//계좌이체 하기
	public void bankTransfer(String who, String target, String bankname, int amount)throws Exception {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps4 = null;
		ResultSet rs1= null;
		ResultSet rs2= null;
		
		try {
			conn = getConnect();
			
			conn.setAutoCommit(false);	
			ps1 = conn.prepareStatement(ServerInfo.SELECT_AQUERY);
			ps1.setString(1, who);
			rs1 = ps1.executeQuery();
			rs1.next();
			int withdrawamount = rs1.getInt("balance");
			if(withdrawamount<amount) 
				throw new Exception("인출하려는 금액이 잔액보다 더 많아요~~!!");
			//연진의 계좌에서 150만원이 출금됨	
			ps2 = conn.prepareStatement(ServerInfo.DECREASE_UPDATE);
			ps2.setInt(1, amount);
			ps2.setString(2, who);
			ps2.executeUpdate();
			
			//동은의 계좌로 150만원이 입금된
			ps3 = conn.prepareStatement(ServerInfo.INCREASE_UPDATE);
			ps3.setInt(1, amount);
			ps3.setString(2, target);
			ps3.executeUpdate();
			
			conn.commit(); //!!!
			
		}catch(Exception e){
			System.out.println("============= 계좌 이체시 오류 발생 ====================");
			System.out.println(e.getMessage());
			conn.rollback();
		}finally {
			System.out.println("============= 계좌 이체후 최종 정보 확인 ====================");
			
			ps4 = conn.prepareStatement(ServerInfo.SELECT_QUERY);
			
			System.out.println("ps3 생성...");
			rs2 = ps4.executeQuery();
			System.out.println("rs 생성...");
			rs2 = ps4.executeQuery();
			while(rs2.next()) {
				System.out.println(rs2.getString("name")+"\t"
						          +rs2.getString("bankname")+"\t"
						          +rs2.getInt("balance")+" 만원");
			}
			conn.setAutoCommit(true); //!!!
			
			if(rs1!=null)rs1.close();
			if(rs2!=null)rs2.close();
			
			if(ps1!=null)ps1.close();
			if(ps2!=null)ps2.close();
			if(ps3!=null)ps3.close();
			if(ps4!=null)ps4.close();
			if(conn!=null)conn.close();
			
		}
	}
}
