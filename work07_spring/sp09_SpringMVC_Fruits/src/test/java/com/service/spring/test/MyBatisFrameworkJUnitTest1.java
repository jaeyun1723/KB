package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.Item;
//JUnit 사용한 단위 테스트
public class MyBatisFrameworkJUnitTest1 {

	@Test
	public void unit() throws Exception
	{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();

		List<Item> list = session.selectList("ns.sql.ItemMapper.getItemList");
		for (Item i : list)
			System.out.println(i);
		System.out.println("====================================");
		Item item = session.selectOne("ns.sql.ItemMapper.getItem", 1111);
		System.out.println(item);
	}

}
