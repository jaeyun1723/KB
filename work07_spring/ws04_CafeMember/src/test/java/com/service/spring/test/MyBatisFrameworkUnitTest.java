package com.service.spring.test;

import java.io.Reader;
import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.junit.Test;

import com.service.spring.domain.MemberVO;


public class MyBatisFrameworkUnitTest {

	@Test
	public void unit() throws Exception{
		// 1. SqlSessionFactory -- SqlSessionFactoryBean
		SqlSessionFactory factory=TestUtil.getSqlSessionFactory();
		
		// 2. SqlSession -- SqlSessionTemplate
		SqlSession session = factory.openSession();
		
		// 3. 쿼리문 실행
		
		//1. registerMember	
//		System.out.println("========= 1. registerMember  ==========");
//		MemberVO vo = new MemberVO("777", "123", "아이유", "여의도");
//		int row=session.insert("MemberMapper.registerMember",vo);
//		System.out.println(row+" 명이 추가 성공!!");
//		session.commit();
//		
//		vo = new MemberVO("333", "123", "김재윤", "잠실");
//		row=session.insert("MemberMapper.registerMember",vo);
//		System.out.println(row+" 명이 추가 성공!!");
//		session.commit();
//		
//		System.out.println("=======================================");
		
//		//2. updateMember
//		System.out.println("========= 2. updateMember  ==========");
//		MemberVO vo = new MemberVO("777", "123", "아이유2", "방배동");
//		int row=session.update("MemberMapper.updateMember",vo);
//		System.out.println(row+" 명이 수정 성공!!");
//		session.commit();
//		
//		System.out.println("=======================================");
//		
//		//3. deleteMember
//		System.out.println("========= 3. deleteMember  ============");
//		row=session.delete("MemberMapper.deleteMember","333");
//		System.out.println(row+" 명이 삭제 성공!!");
//		session.commit();
		
		System.out.println("=======================================");
		
		//4. getMember
		System.out.println("========= 4. getMember  ============");
		MemberVO vo=session.selectOne("MemberMapper.getMember","123");
		System.out.println(vo);
		
		System.out.println("=======================================");
		
		//5. showAllMember
		System.out.println("========= 5. showAllMember  ============");
		List<MemberVO> list = session.selectList("MemberMapper.showAllMember");
		for(MemberVO member : list) {
			System.out.println(member);
		}
		
		System.out.println("=======================================");
		
		//6. idExist
		System.out.println("========= 6. idExist  ============");
		String id=session.selectOne("MemberMapper.idExist","321");
		System.out.println(id);
		
		
	}//
}//
