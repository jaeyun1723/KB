package spring.service.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.user.MemberService;

public class MyBatisSpringDIAppTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
								new String[] {	"/beans/memberservice.xml"	 });
		
		MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
		
		MemberVO user;

		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		user = memberService.getMember("777");
		System.out.println(":: 1. get(SELECT)  ? "+user);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		System.out.println(":: 2. all User(SELECT)  ? ");
		List<MemberVO> list = memberService.showAllMember();
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
			System.out.println( list.get(i).toString() );
		}
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		String id = memberService.idExist("777");
		System.out.println(":: 3n. idExist(SELECT)  ? "+id);
	}

}
