<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax11</title>
</head>
<body>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#btn1").click(function(){
			
			//$("#txtDiv").text("text changed");
			
			//$.ajax(); // get이나 post 선택 가능
			$.get(
				"${pageContext.request.contextPath}/ajax11return"
				, {
					data1: $("#txt1").val(),
					data2: $("#txt2").val()
				}
				, function(data, status) { // data: 서버가 보내는 결과값, status : 통신 성공 여부
					$("#txtDiv").text(data);
				}
				
			); // get 방식 가능
			// 1. 서버 주소 , 2. 서버로 보낼 데이터 , 3. call back method(서버가 돌려주는 결과 값) 4. json 모드 <- 간혹
			
			
			//$.post(); // post 방식 가능
			
		}); // 
	});
	</script>
	<h1>프로젝트 url : ${pageContext.request.contextPath} : server.xml 의 Context path</h1>
	<div id="txtDiv">이 곳의 텍스트를 바꾸는 예제</div>
	<button type="button" id="btn1"> Call Ajax </button>
	
	<input type="text" id="txt1" value="신입사원">
	<input type="text" id="txt2" value="education">
</body>
</html>