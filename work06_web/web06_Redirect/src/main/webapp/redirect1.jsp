<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	String url = "https://search.naver.com/search.naver?";
	String word = request.getParameter("word");
	url += "query=" + word;

	// 페이지 이동.. redirect 방식
	response.sendRedirect(url); // 네이버가 응답
	// forward : 같은 서버 내에 있는 component들끼리 이동하는 방법
	%>
</body>
</html>