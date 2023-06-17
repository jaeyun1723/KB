package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BranchesController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("handleRequest...진입..");

		// 디비 갔다 왔다 치고..
		String result = "<ul><li>선릉지점</li><br>" + "<li>강남지점</li><br>" + 
				"<li>역삼지점</li><br>" + "<li>강북지점</li><br>"
				+ "<li>잠실지점</li><br>";
		request.setAttribute("result", result);
		return new ModelAndView("Result.jsp");
	}

}
