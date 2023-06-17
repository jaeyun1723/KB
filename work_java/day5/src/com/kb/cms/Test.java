package com.kb.cms;

public class Test {

	public static void main(String[] args) {
		ICustMgr mgr = new CustManager();
		mgr.save(new Customer(1001,"kim","서울"));
		mgr.save(new Customer(1002,"park","인천"));
		mgr.save(new Customer(1003,"lee","부산"));
		mgr.save(new VipCustomer(4001,"kang","광주","12가3456"));
		mgr.save(new VipCustomer(4002,"jo","울산","56나7890"));
		
		
		System.out.println("=== 전체 검색 ===");
		mgr.search();
		System.out.println("sorted 검색");
		mgr.sortedSearch();
	
		System.out.println("=== 1003 검색 ===");
		System.out.println(mgr.search(1003));
		
		System.out.println("=== 1003 수정 주소 : 부산===");
		mgr.update(1003, "부산");
		System.out.println(mgr.search(1003));
		
		System.out.println("=== 1003 삭제===");
		mgr.delete(1003);
		System.out.println(mgr.search(1003));
		
		
		
	}

}
