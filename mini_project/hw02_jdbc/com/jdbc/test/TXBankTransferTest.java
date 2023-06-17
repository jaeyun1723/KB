package com.jdbc.test;

import com.jdbc.dao.TXBankDAO;

import config.ServerInfo;

public class TXBankTransferTest {
	public static void main(String[] args) throws Exception{
		TXBankDAO dao =TXBankDAO.getInstance();
		
		dao.bankTransfer("연진", "동은", "국민", 500000);
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 설공..");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패..");
		}
	}
}
