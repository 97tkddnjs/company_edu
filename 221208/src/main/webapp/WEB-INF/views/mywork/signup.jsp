<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		
	$(document).ready(function() {
		$("#idchk").click(function(){
			$.post(
					"${pageContext.request.contextPath}/idCheck"
					, {	
						id : $("#id").val()	
					 }
					, function(data, status) {
						//alert(data);
						
						if(data=='false'){	
							alert("중복 체크 통과 되었습니다.");
							$("#idchk").css("color", "blue");
						}else{
							alert(data)
							alert("id를 다시 체크해보세요");
						}
							
					}//function
			);//post
			
		}) // click
		
		$("#signup").click(function(){
			$.post(
					"${pageContext.request.contextPath}/signupIn"
					, {	
						id : $("#id").val(),
						pwd : $("#pwd").val(),
						name : $("#name").val()	
					 }
					, function(data, status) {
						//alert(data);
						
						if(data=='true'){	
							alert("회원 가입이 되었습니다.");
							
						}else{
							alert("다시 체크하세요");
						}
							
					}//function
			);//post
			
		}) // click
		
		$("#pwdcheck").keyup(function(){
			let inputPwd = $("#pwd").val();
			let pwdCheck = $(this).val();
			
			if(inputPwd == pwdCheck){
				$("#check").text("같아요");
			}else{
				$("#check").text("달라요");
			}
			
			
		}) // click
		
	}) // ready
	
	</script>


	<form action="./signupIn">
		<table class="table table-hover">
				<tbody>
					<tr>
						<td> id </td>
						<td>
							<input type="text" id="id" name="id" class="form-control">
						</td>
						<td>
							<button type="button" id="idchk"> id 중복 체크 </button>
						</td>
					</tr>
					
					<tr>
						<th> password </th>
						<td>
							<input type="password" id="pwd" name="pwd" class="form-control">
						</td>
					</tr>
					<tr>
						<th> password check</th>
						<td>
							<input type="password" id="pwdcheck" name="pwdcheck" class="form-control">
						</td>
						<td id="check">
						</td>
					</tr>
					
					<tr>
						<td> name </td>
						<td>
							<input type="text" id="name" name="name" class="form-control">
						</td>
					</tr>
					
				</tbody>
			</table>
			
			<button type="button" id="signup"> 회원가입 </button>
			<button type="button" onclick="javascript:history.back();"> 취소 </button>
	</form>
</body>
</html>