package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <servlet> <servlet-name>FormServlet
 * <servlet-class>web.servlet.form.FormServlet </servlet> <servlet-mapping>
 * <servlet-name>FormServlet <url-pattern>/FS </servlet-mapping>
 * 
 */
@WebServlet("/FS") // annotation
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// thread..
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("서비스는 이쪽으로 들어옵니다..");

		// 폼에 입력된 값 받아서 다시 브라우저로 응답...
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pass");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<ul><li>ID : " + userId + "</li>");
		out.println("<li>PASS : " + userPass + "</li></ul>");
		out.println("</body></html>");

		out.close();
	}

}
