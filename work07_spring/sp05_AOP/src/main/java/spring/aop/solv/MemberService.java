package spring.aop.solv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.lf5.viewer.LogFactor5Dialog;

/*
 * Core Concern만으로 작성된 클래스... Target
 * 
 */
public class MemberService {

	public void register(String id) {
		System.out.println("register...logic..회원등록 성공");
	}
	
	public void findMember(String id) {
		System.out.println("findMember...logic..회원검색 성공");
		
	}
	
}
