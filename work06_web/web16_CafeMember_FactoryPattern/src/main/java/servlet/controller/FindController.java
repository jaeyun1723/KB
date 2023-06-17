package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller {
	/*
	 * MVC -- FindController 서블릿과 동일 FrontController -- 서블릿 안의 find() 함수와 동일
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 2. 폼값 받아서
		String id = request.getParameter("id");
		// 3. DAO리턴받고 비즈니스 로직 호출... 반환값있다.
		// 4. 반환값을 바인딩
		String path = "find_fail.jsp";
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			request.setAttribute("vo", rvo);
			path = "find_ok.jsp";
		} catch (Exception e) {

		}
		return new ModelAndView(path);
	}

}
