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
<title> LOG IN /LOG OUT </title>
</head>
	<body>
		<div class="container">
			<form id="login_form" action="${pageContext.request.contextPath}/inout/login"> 
				아이디 : <input type="text" id="mid" name="mid" class="form-control">
				
				패스워드 : <input type="password" id="mpwd" name="mpwd" class="form-control">
				<br>
				<button type="submit" class="btn btn-warning"> LOG IN </button>
			</form>
			<hr>
			
			<form id="logout_form" action="${pageContext.request.contextPath}/inout/logout">
				<button type="submit" class="btn btn-danger"> LOG OUT </button>
			</form>
		</div>
	</body>
</html>