package com.itskb.ws4.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankService {
	List<AccountDto> accountList;
	List<UserDto> userList;

	BankService() {

		accountList = new ArrayList<AccountDto>();
		userList = new ArrayList<UserDto>();

		userList.add(new UserDto(1001, "kim", "@", "010-222-3333", false));
		userList.add(new UserDto(1001, "kim", "@", "010-222-3333", false));
		userList.add(new UserDto(1002, "lee", "@", "010-444-5555", true));
		userList.add(new UserDto(1003, "kang", "@", "010-666-7777", false));

		accountList.add(new AccountDto(1, "11-111", 1000000, 1001));
		accountList.add(new AccountDto(2, "22-222", 2000000, 1003));
		accountList.add(new AccountDto(3, "33-333", 3000000, 1001));

	}

	public List<AccountDto> getAccountList(int userSeq) {
		List<AccountDto> result = new ArrayList<AccountDto>();
		for (AccountDto c : accountList)
			if (c.userSeq == userSeq)
				result.add(c);
		return result;
	}

	public UserDto getUserDetail(int userSeq) {
		for (UserDto c : userList)
			if (c.userSeq == userSeq)
				return c;
		return null;
	}
}
