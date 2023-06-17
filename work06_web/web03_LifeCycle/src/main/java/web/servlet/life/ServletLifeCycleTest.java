package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet API와 컨테이너가 어떻게 CALLBACK 메소드를 호출하는지... 순서...
 */
//@WebServlet("/Life")
@WebServlet(urlPatterns= {"/Life"}, loadOnStartup = 1)
public class ServletLifeCycleTest extends HttpServlet {	// 컨테이너가 접근하기 때문에 public으로 설정
	private static final long serialVersionUID = 1L;
	private int count=0;

	public ServletLifeCycleTest() {
		System.out.println("1. 서블릿 객체 생성... 컨테이너에 의해서...");
	}

	
	public void init(ServletConfig config) throws ServletException {	// 생성자로 필드초기화 못해서 나온 
																		//	init함수를 통해 필드 초기화
		super.init(config);
		System.out.println("2. init() 호출.... 컨테이너에 의해서...");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("4. destroy() 호출.... 컨테이너에 의해서... 호출되고, 컨터이너에 의해 죽고...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("3. doGet() 호출.... 컨테이너에 의해서... 요청때마다 계속 호출...");
		PrintWriter out = response.getWriter();
		
		out.println("<body bgcolor='yellow'>");
		out.println("<h3>LifeCycle CallBack Method...</h3>");
		out.println("<b>Count :: "+(++count)+"</b>");
		out.println("</body>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("3. doPost() 호출.... 컨테이너에 의해서... 요청때마다 계속 호출...");
	}

}
