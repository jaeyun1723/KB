package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.MyProductDAO;
import com.service.spring.domain.MyProduct;

@Service
public class MyProductServiceImpl implements MyProductService {

	@Autowired
	private MyProductDAO myproductDAO;
	
	@Override
	public int addProduct(MyProduct vo) throws Exception {
		return myproductDAO.addProduct(vo);
	}

	@Override
	public List<MyProduct> findProductByName(String name) throws Exception {
		return myproductDAO.findProductByName(name);
	}

	@Override
	public List<MyProduct> findProductByMaker(String maker) throws Exception {
		return myproductDAO.findProductByMaker(maker);
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		return myproductDAO.findProducts();
	}

	

}
