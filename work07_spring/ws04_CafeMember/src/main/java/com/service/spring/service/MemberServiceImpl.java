package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.MemberDAO;
import com.service.spring.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO dao;
	
	@Override
	public int registerMember(MemberVO vo) throws Exception {
		return dao.registerMember(vo);
	}

	@Override
	public int updateMember(MemberVO vo) throws Exception {
		return dao.updateMember(vo);
	}

	@Override
	public List<MemberVO> showAllMember() throws Exception {
		return dao.showAllMember();
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return dao.getMember(id);
	}

	@Override
	public String idExist(String id) throws Exception {
		return dao.idExist(id);
	}

}
