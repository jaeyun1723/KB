package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet_sol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 public LifeCycleServlet_sol() {
	    	System.out.println("LifeCycleServlet() is called!!!");
	    }

		@Override
		public void destroy() { // 서버를 강제 종료하면 안보임, 서블릿에 대한 요청을 하고(생성자 / init 실행) 난 후 수정하면, 서버가 자동으로 리스타트하는 데 이 때 보임
			System.out.println("destroy() is called!!!!!!");
		}

		@Override
		public void init(ServletConfig config) throws ServletException {
			System.out.println("init() is called!!!");
		}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doGet() is called!!!");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.write("<h1>안녕하세요, LifeCycleServlet 입니다.</h1>");
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doPost() is called!!!");
			doGet(request, response);
		}
	}
