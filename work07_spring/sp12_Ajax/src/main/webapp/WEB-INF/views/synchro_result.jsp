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
			// 요청
			type: 'get',
			url: 'asynch',
			
			// 응답
			success:function(data){ // 객체 단위로 데이터를 받아옴...(JSON방식)
				var jsonData=JSON.parse(data);	// 반드시 parsing한 다음 사용
				$('#jsonView').html("<h3><font color='red'>"+jsonData.person.name+"가 사는 곳은 "
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
<input type="button" value="비동기 통신 시작하기" id="asynch">
<!-- 비동기 통신은 결과페이지가  별도로 존재하는 것이 아니라 요청한 바로 그 페이지의 특정 영역으로 출력-->
<span id="jsonView"></span>
</body>
</html>