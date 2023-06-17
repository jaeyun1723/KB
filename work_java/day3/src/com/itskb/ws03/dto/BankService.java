package com.itskb.ws03.dto;

import java.util.Scanner;

public class BankService {
	final int ACCOUNT_SIZE = 5;
	final int USER_SIZE = 10;
	int uIndex = 0;
	int aIndex = 0;
	AccountDto[] accountList;
	UserDto[] userList;

	BankService() {
		accountList = new AccountDto[ACCOUNT_SIZE];
		userList = new UserDto[USER_SIZE];

		userList[uIndex++] = new UserDto(1001, "kim", "@", "010-222-3333", false);
		userList[uIndex++] = new UserDto(1002, "lee", "@", "010-444-5555", true);
		userList[uIndex++] = new UserDto(1003, "kang", "@", "010-666-7777", false);

		accountList[aIndex++] = new AccountDto(1, "11-111", 1000000, 1001);
		accountList[aIndex++] = new AccountDto(2, "22-222", 2000000, 1003);
		accountList[aIndex++] = new AccountDto(3, "33-333", 3000000, 1001);
	}

	public AccountDto[] getAccountList(int userSeq) {
		int count = 0;
		for (int i = 0; i < aIndex; i++)
			if (accountList[i].userSeq == userSeq)
				count++;
		AccountDto[] result = new AccountDto[count];
		int idx = 0;
		for (int i = 0; i < aIndex; i++)
			if (accountList[i].userSeq == userSeq)
				result[idx++] = accountList[i];
		return result;
	}

	public UserDto getUserDetail(int userSeq) {
		UserDto result = null;
		for (int i = 0; i < uIndex; i++)
			if (userList[i].userSeq == userSeq) {
				result = userList[i];
				break;
			}
		return result;
	}
	
//	public static void main(String[] args) {
//		BankService ser = new BankService();
//		AccountDto[] result = ser.getAccountList(1001);
//		for (AccountDto dto : result)
//			System.out.println(dto);
//		System.out.println(ser.getUserDetail(1003));		
//	}
}
