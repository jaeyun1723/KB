package web.servlet.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/params")
public class ParameterServlet_sol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ParameterServlet_sol() {
        super();
        
    }
   
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
 		//한글처리
    	request.setCharacterEncoding("utf-8"); 
 		response.setContentType("text/html; charset=utf-8");
 		
 		//1. get방식 form값 처리하기 		
 		String job = request.getParameter("job");	
 		String pageNo = request.getParameter("pageNo");		
 		String word = request.getParameter("searchWord");
 		// 서버 출력
 		System.out.println("job : " + job);
 		System.out.println("pageNo : " + pageNo);
 		System.out.println("searchWord : " + word);
 		
 		// 브라우저에 보내기
 		// use StringBuilder
 		StringBuilder sb = new StringBuilder();
 		sb.append("<h2>job : ").append(job).append("</h2>");
 		sb.append("<h2>pageNo : ").append(pageNo).append("</h2>");
 		sb.append("<h2>searchWord : ").append(word).append("</h2>");
 				
 		response.getWriter().append(sb);
 	}

 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		//한글처리
    	request.setCharacterEncoding("utf-8"); 
 		response.setContentType("text/html; charset=utf-8");
 		
 		//2. post방식 form값 처리하기 
 		String name = request.getParameter("name");
 		String email = request.getParameter("email");
 		String gender = request.getParameter("gender");
 		
 		String hobby[] = request.getParameterValues("hobby");
 		StringBuilder sbHobby = new StringBuilder();
 		for (String h : hobby) {
 			sbHobby.append(h).append(", ");
 		}
 		sbHobby.setLength(sbHobby.length()-2);
 		
 		String favorite = request.getParameter("favorite");
 		String desc = request.getParameter("desc");

 		// 서버 출력
 		System.out.println("name : " + name);
 		System.out.println("email : " + email);
 		System.out.println("gender : " + gender);
 		System.out.println("hobby : " + sbHobby);
 		System.out.println("favorite : " + favorite);
 		System.out.println("desc : " + desc);
 		
 		// 브라우저에 보내기
 		// use StringBuilder
 		StringBuilder sb = new StringBuilder();
 		sb.append("<h1>name : ").append(name).append("</h1>");
 		sb.append("<h1>email : ").append(email).append("</h1>");
 		sb.append("<h1>gender : ").append(gender).append("</h1>");
 		sb.append("<h1>hobby : ").append(sbHobby).append("</h1>");
 		sb.append("<h1>favorite : ").append(favorite).append("</h1>");
 		sb.append("<h1>desc : ").append(desc).append("</h1>");
 				
 		response.getWriter().append(sb);
 		
 		
 	}

 }
