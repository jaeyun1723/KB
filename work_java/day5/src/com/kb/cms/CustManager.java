package com.kb.cms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustManager implements ICustMgr {
	List<Customer> cs = new ArrayList<>();

	public void save(Customer c) {
		cs.add(c);
	}

	public void search() {
		System.out.println(cs);
	}

	public void sortedSearch() {
	//	Collections.sort(cs);
		Collections.sort(cs,new MyComparator("주소"));
		System.out.println(cs);
	}

	
	public Customer search(int num) {
		for (Customer c : cs)
			if (c.num == num)
				return c;
		return null;
	}

	public void update(int num, String address) {
		Customer c=search(num);
		if(c!=null)
			c.address=address;
		else
			System.out.println("수정 실패 : 고객번호가 잘못 되었습니다.");
//		for (Customer c : cs)
//			if (c.num == num)
//				c.address = address;
	}

	public void delete(int num) {
		Customer c=search(num);
		if(c!=null)
			cs.remove(c);
		else
			System.out.println("삭제 실패 : 고객번호가 잘못 되었습니다.");
//		for (int i = 0; i < cs.size(); i++)
//			if (cs.get(i).num == num)
//				cs.remove(i);
	}

}
