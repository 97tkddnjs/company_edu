<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
		<div class="container">
			<h1>
				Hello world!  
			</h1>
			<P>  The time on the server is ${serverTime}. </P>
			<form method="get" action="./signup">
				<button type="submit"> 회원 가입하기 </button>
			</form>
			<table class="table table-hover">
				<tr>
					<td> <a href="${pageContext.request.contextPath}/file1/form">file1</a> </td>
					<td> <a href="${pageContext.request.contextPath}/file2/form">file2</a> </td>
					<td> <a href="${pageContext.request.contextPath}/file11/form">file11</a> </td>
					<td> <a href="${pageContext.request.contextPath}/file12/form">file12</a> </td>
				</tr>
				
			</table>
		</div>
	</body>
</html>









