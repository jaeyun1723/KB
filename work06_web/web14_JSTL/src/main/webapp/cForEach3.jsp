<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>c:forEach ���� ����ϱ�</title>
</head>
<body>

<c:forEach var="cnt" begin="1" end="10">
<font size="${cnt}">Hello NiceDay~~!!</font><br>



</c:forEach>


</body>
</html>