package com.service.spring.dao;

import java.util.List;

import com.service.spring.domain.Item;

// ~mapping.xml 쿼리문 id 값이 메소드 이름
public interface ItemDAO {
	List<Item> getItemList() throws Exception;
	Item getItem(Integer itemId) throws Exception;
}
