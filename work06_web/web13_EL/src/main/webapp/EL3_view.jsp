<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<b>정보 출력</b>
	<br> ${vo} <!-- request.getAttribute("vo") -->
	<br> ID : ${vo.id } <!-- request.getAttribute("vo.getId()") -->
	<br> NAME : ${vo.name} <!-- request.getAttribute("vo.getName()") -->
	<br>
</body>
</html>