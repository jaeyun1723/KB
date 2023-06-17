package com.kb.cms;

public interface ICustMgr {

	void save(Customer c);

	void search();
	
	public void sortedSearch();
	
	Customer search(int num);
	
	/**
	 * @param num : 고객번호
	 * @param address : 수정된 주소
	 */
	
	void update(int num, String address);

	void delete(int num);

}