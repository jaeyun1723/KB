package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.MemberVO;

public interface MemberService {
	int registerMember(MemberVO vo) throws Exception;

	int updateMember(MemberVO vo) throws Exception;

	List<MemberVO> showAllMember() throws Exception;

	MemberVO getMember(String id) throws Exception;

	String idExist(String id) throws Exception;
}
