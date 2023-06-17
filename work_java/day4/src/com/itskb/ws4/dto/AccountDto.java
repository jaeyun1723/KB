package com.itskb.ws4.dto;

public class AccountDto {
	int accountSeq;
	String accountNumber;
	int balance;
	int userSeq;
	
	public AccountDto() {}
	public AccountDto(int accountSeq, String accountNumber, int balance, int userSeq) {
		this.accountSeq=accountSeq;
		this.accountNumber=accountNumber;
		this.balance=balance;
		this.userSeq=userSeq;
	}
	
	@Override
	public String toString() {
		return "AccountDto [accountSeq=" + accountSeq + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", userSeq=" + userSeq + "]";
	}
	
}
