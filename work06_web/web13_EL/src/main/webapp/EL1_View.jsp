<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- ������ ���������� �ۼ��ؾ� �ϴµ�... �ϴ� �������̶�� ġ��.. --%>
<!-- ������ ���������� �ۼ��ؾ� �ϴµ�... �ϴ� �������̶�� ġ��.. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP �⺻ Element�� �޾ƿ���</b><br>
<%= request.getAttribute("RESULT1") %><br>
<%= session.getAttribute("RESULT2") %><br>

<hr>
<b>2. JSP EL �� �޾ƿ���</b><br>

1. ${RESULT1}<br>
2. ${RESULT2}<br>
3. ${RESULT1+100000}<br>
</body>
</html>