package servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 다시 요청이 들어가면 새로운 세션이 생길 수 있지만... 세션을 죽이지 않는 이상 쿠키를 통해서
		// jsessionid 값이 다시 서버로 날라가고 서버는 이 값을 열어봐서 기존의 세션으로 요청을 유지함.
		// 이러한 요청이 바로 로그인... 로그인 유지 기간.
		HttpSession session = request.getSession(); // 기존의 세션으로 연결... 세션을 죽여야지만 새로운 세션으로 연걸
		if (session.getAttribute("vo") != null) { // 로그인된 상태라면... 기존 세션이라면
			//MemberVO vo = (MemberVO) session.getAttribute("vo");
			System.out.println("JSESSIONID : " + session.getId());
			session.setAttribute("pname", "book");
			request.getRequestDispatcher("buy_result.jsp").forward(request, response);
		} else { // 로그인된 상태가 아니라면... 기존 세션이 죽었다면은
			response.sendRedirect("login.html");
		}
	}

}