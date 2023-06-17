package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterServlet
 */
@WebServlet(urlPatterns = { "/params" }, loadOnStartup = 1)
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ParameterServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String job = request.getParameter("job");
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		String searchWord = request.getParameter("searchWord");
		StringBuilder sb= new StringBuilder();
		sb.append("<h2>job : ").append(job).append("</h2>");
		sb.append("<h2>pageNo : ").append(pageNo).append("</h2>");
		sb.append("<h2>searchWord : ").append(searchWord).append("</h2>");
		out.append(sb);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String gender= request.getParameter("gender");
		String[] hobby=request.getParameterValues("hobby");
		String favorite=request.getParameter("favorite");
		String desc=request.getParameter("desc");
		
		StringBuilder sb= new StringBuilder();
		sb.append("<h2>name : ").append(name).append("</h2>");
		sb.append("<h2>email : ").append(email).append("</h2>");
		sb.append("<h2>gender : ").append(gender).append("</h2>");
		StringBuilder sb2=new StringBuilder();
		for(String s : hobby) sb2.append(s).append(", ");
		sb2.setLength(sb2.length()-2);
		sb.append("<h2>hobby : ").append(sb2).append("</h2>");
		sb.append("<h2>desc : ").append(desc).append("</h2>");

		out.append(sb);
	}

}
