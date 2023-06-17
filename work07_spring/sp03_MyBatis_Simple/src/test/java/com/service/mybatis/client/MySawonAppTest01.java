package com.service.mybatis.client;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest01 {

	public static void main(String[] args) throws Exception {
		// 1. 폼으로부터 값을 받아서..vo 생성
		MySawon vo = new MySawon();
		vo.setId("haha");
		vo.setPwd("1234");
		vo.setName("길복순");
		vo.setAge(28);

		// 2. MyBatis 핵심설정문서 읽어들인다.
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		// 3. SqlSessionFactory 생성
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

		// 4. SqlSession 생성
		SqlSession session = factory.openSession();

		/*
		 * SqlSession에는 쿼리문을 실행하는 함수가 다 들어있다. int insert() int delete() int update()
		 * Object selectOne List selectList()
		 */

		session.insert("sawonMapper.sawonAdd", vo);
		System.out.println(vo.getName() + "님 회원등록 성공^^");
		session.commit();
		session.close();

	}

}
