package com.service.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.MemberVO;
import com.service.spring.service.MemberService;

public class SpringDIMyBatisJUnitTest {
	@Test
	public void unit() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/beans/businessLogicBean.xml" });

		// ==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
		MemberService memberService = (MemberService) context.getBean("memberServiceImpl"); // 소문자

		MemberVO member = new MemberVO("user04", "1234", "user04", "seoul");

//		System.out.println("========= 1. registerMember  ==========");
//		int row = memberService.registerMember(member);
//		System.out.println(row + "행 추가 성공!!");
//		System.out.println("=======================================");
//
//		System.out.println("========= 2. updateMember  ==========");
//		member = new MemberVO("user04", "4321", "user05", "jamsil");
//		row = memberService.updateMember(member);
//		System.out.println(row + "행 업데이트 성공!!");
//		System.out.println("=======================================");

		System.out.println("========= 3. showAllMember  ==========");
		List<MemberVO> list = memberService.showAllMember();
		for (MemberVO m : list)
			System.out.println(m);
		System.out.println("=======================================");
		
		System.out.println("========= 4. getMember  ==========");
		member = memberService.getMember("123");
		System.out.println(member);
		System.out.println("=======================================");
		
		System.out.println("========= 5. idExist  ==========");
		String id = memberService.idExist("user04");
		System.out.println(id);
		System.out.println("=======================================");
	}
}
