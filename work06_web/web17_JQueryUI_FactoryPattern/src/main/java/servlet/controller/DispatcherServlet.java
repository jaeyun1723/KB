package servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
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

		// 앞에서 들어온 요청의 주소를 그대로 받는다..
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI : " + requestURI);

		String contextpath = request.getContextPath();
		System.out.println("ContextPath : " + contextpath);

		String command = requestURI.substring(contextpath.length() + 1);

		ModelAndView mv = null;
		// 1. 공장에게 command값을 주고 Controller를 받는다.
		Controller controller = HandlerMapping.getInstance().createComponent(command);

		// 2. Controller의 메소드를 호출...ModelAndView 받는다.
		mv = controller.handleRequest(request, response);

		// 3. 네비게이션
		if (mv != null) {
			if (mv.isRedirect())
				response.sendRedirect(mv.getPath());
			else
				request.getRequestDispatcher(mv.getPath()).forward(request, response);
		}
	}// doprocess
}// servlet
