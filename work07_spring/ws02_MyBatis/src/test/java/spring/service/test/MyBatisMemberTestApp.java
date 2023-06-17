package spring.service.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;

public class MyBatisMemberTestApp {

	public static void main(String[] args) throws IOException {

		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();

		MemberVO vo = new MemberVO("jy97", "1234", "김재윤", "잠실");
//		vo = new MemberVO("kim", "1234", "kim", "문정");

//		System.out.println("1. registerMember");
//		Object obj = session.insert("MemberMapper.registerMember", vo);
//		session.commit();
//		System.out.println("INSERT : "+ obj);
//		System.out.pridntln("\n");

//		vo.setId("kim");
//		System.out.println("2. deleteMember");
//		int deleteResult = session.delete("MemberMapper.deleteMember", vo.getId());
//		session.commit();
//		System.out.println("DELETE : "+ deleteResult);
//		System.out.println("\n");

//		vo.setName("김혜영");
//		System.out.println("3. updateMember");
//		int updateResult = session.update("MemberMapper.updateMember", vo);
//		session.commit();
//		System.out.println("UPDATE : " + updateResult);
//		System.out.println("\n");

//		System.out.println("4. showAllMember");
//		List<MemberVO> list = session.selectList("MemberMapper.showAllMember");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("[" + (i + 1) + "번째 회원 ] " + list.get(i).toString());
//		}
//		System.out.println("\n");
		
//		System.out.println("5. getMember");
//		MemberVO member=session.selectOne("MemberMapper.getMember",vo.getId());
//		System.out.println(member);
//		System.out.println("\n");
		
//		System.out.println("6. idExist");
//		String idExist=(String)session.selectOne("MemberMapper.idExist",vo.getId());
//		if(idExist!=null) System.out.println("해당 ID가 존재합니다.");
//		else System.out.println("ID가 존재하지 않습니다.");
		
//		System.out.println("7. login");
//		vo.setId("jy97");
//		vo.setPassword("1234");
//		String login=(String)session.selectOne("MemberMapper.login",vo);
//		if(login!=null) System.out.println("로그인되었습니다.");
//		else System.out.println("ID 혹은 PW가 일치하지 않습니다.");
	}//

}//
