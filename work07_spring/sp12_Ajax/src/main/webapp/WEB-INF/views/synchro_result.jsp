<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
$(function(){
	$('#asynch').click(function(){
		$.ajax({
			// ��û
			type: 'get',
			url: 'asynch',
			
			// ����
			success:function(data){ // ��ü ������ �����͸� �޾ƿ�...(JSON���)
				var jsonData=JSON.parse(data);	// �ݵ�� parsing�� ���� ���
				$('#jsonView').html("<h3><font color='red'>"+jsonData.person.name+"�� ��� ���� "
						+jsonData.person.address+"!!</font></h3>");
			} // callback
		}); // ajax
	}); // click
});
</script>
</head>
<body>
${info}
<p></p>
<hr>
<input type="button" value="�񵿱� ��� �����ϱ�" id="asynch">
<!-- �񵿱� ����� �����������  ������ �����ϴ� ���� �ƴ϶� ��û�� �ٷ� �� �������� Ư�� �������� ���-->
<span id="jsonView"></span>
</body>
</html>