package com.kb.cms2;

public class Test {

	public static void main(String[] args) {
		CarManager mgr = new CarManager();
		mgr.save(new Bus("111",1000,41));
		mgr.save(new Bus("211",2000,42));
		mgr.save(new Bus("311",3000,43));
		mgr.search();
		mgr.delete("211");
		System.out.println(mgr);
		System.out.println(mgr.search("111"));
	}

}
