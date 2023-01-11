<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

<title> LOG IN /LOG OUT </title>
</head>
	<body>
		<%@ include file="/WEB-INF/views/newboard/navbar.jsp" %>
		<div class="container">
			<form id="login_form" action="${pageContext.request.contextPath}/newboard/login" method="post"> 
				아이디 : <input type="text" id="mid" name="member_login_id" class="form-control">
				
				패스워드 : <input type="password" id="mpwd" name="member_pwd" class="form-control">
				<br>
				<button type="submit" class="btn btn-primary"> LOG IN </button>
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/newboard/signup'" 
				class="btn btn-warning"> 회원 가입 </button>
			</form>
			<hr>
			
		</div>
	</body>
</html>