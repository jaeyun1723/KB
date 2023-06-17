package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.membership.MemberImpl;

import servlet.model.MemberDAO;
import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/*
		 * 2. 폼값 받아서 3. VO 생성 4. DAO리턴받아서... 비즈니스 로직 호출... 반환값 있다. 5. session에
		 * 바인딩...(req, session,context) 6. 네비게이션
		 */
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "index.html";
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().login(id, password);
			HttpSession session = request.getSession();
			if (rvo != null) { // null인 경우 바인딩 진행 안하도록...
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID : " + session.getId());
			}
			path = "login_result.jsp";
		} catch (Exception e) {
			path = "login_fail.jsp";
			System.out.println(e);
		}

		request.getRequestDispatcher(path).forward(request, response);
	}
}
