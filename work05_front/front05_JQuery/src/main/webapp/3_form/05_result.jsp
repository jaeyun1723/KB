<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp문법 : form에 입력된 값을 출력할 때는 form 의 name을 넣으면 값이 출력됨 -->
<h2> <b> ${param.userName}</b> 님의 정보를 출력합니다.</h2>
아이디 : ${param.userId}<br>
주소 : ${param.userAddr}
</body>
</html>