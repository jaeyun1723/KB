package com.itskb.ws03.dto;

public class Test {

	public static void main(String[] args) {
		BankService ser = new BankService();
		AccountDto[] result = ser.getAccountList(1001);
		for (AccountDto dto : result)
			System.out.println(dto);
		System.out.println(ser.getUserDetail(1003));
		
	}

}
