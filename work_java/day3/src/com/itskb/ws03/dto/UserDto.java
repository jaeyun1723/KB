package com.itskb.ws03.dto;

public class UserDto {
	int userSeq;
	String name,email,phone;
	boolean isSleep;

	UserDto() {}
	UserDto(int userSeq, String name, String email, String phone, boolean isSleep){
		this.userSeq=userSeq;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.isSleep=isSleep;
	}
	
	@Override
	public String toString() {
		return "UserDto [userSeq=" + userSeq + ", name=" + name + ", email=" + email + ", phone=" + phone + ", isSleep="
				+ isSleep + "]";
	}
}