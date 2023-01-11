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
			<form method="get" action="./select_all_emp">
				<button type="submit"> 사원 목록 조회 </button>
			</form>
			<table class="table table-hover">
			
				<tr>
					
					<td> <a href="${pageContext.request.contextPath}/rest/general3"> controller - Json response body </a> </td>
					<td> <a href="${pageContext.request.contextPath}/rest/general2"> controller - response body </a> </td>
					<td> <a href="${pageContext.request.contextPath}/rest/general1"> controller </a> </td>
				</tr>
			
				<tr>
					
					<td> <a href="${pageContext.request.contextPath}/rest2/general"> rest controller</a> </td>
					<td> <a href="${pageContext.request.contextPath}/rest2/general2"> rest controller JSON</a> </td>
				</tr>
			
			
				<tr>
					<td> <a href="${pageContext.request.contextPath}/inout/loginf"> LOGIN </a> </td>
				</tr>
			
				<tr>
					<td> <a href="${pageContext.request.contextPath}/transaction/sample">transaction sample</a> </td>
				</tr>
			
				<tr>
					<td> <a href="${pageContext.request.contextPath}/file1/form">file1</a> </td>
					<td> <a href="${pageContext.request.contextPath}/file2/form">file2</a> </td>
					<td> <a href="${pageContext.request.contextPath}/file11/form">file11</a> </td>
					<td> <a href="${pageContext.request.contextPath}/file12/form">file12</a> </td>
				</tr>
				<tr>
					<td> <a href="./ajax11">Page For Ajax11</a> </td>
					<td> <a href="./ajax12">Page For Ajax12</a> </td>
				</tr>
				<tr>
					<td> <a href="${pageContext.request.contextPath}/json1">json1</a> </td>
					<td> <a href="${pageContext.request.contextPath}/json2">json2</a> </td>
					<td> <a href="${pageContext.request.contextPath}/json11">json11</a> </td>
					<td> <a href="${pageContext.request.contextPath}/json12">json12</a> </td>
					<td> <a href="${pageContext.request.contextPath}/json13">json13</a> </td>
				</tr>
				<tr>
					<td> <a href="./el1">el1</a> </td>
					<td> <a href="./el2">el2</a> </td>
					<td> <a href="./el3">el3</a> </td>
				</tr>
				<tr>
					<td> <a href="./jstl1">jstl1</a> </td>
					<td> <a href="./jstl2">jstl2</a> </td>
					<td> <a href="./jstl3">jstl3</a> </td>
					<td> <a href="./jstl4">jstl4</a> </td>
					<td> <a href="./jstl5">jstl5</a> </td>
					<td> <a href="./jstl6">jstl6</a> </td>
					<td> <a href="./jstl7">jstl7</a> </td>
					<td> <a href="./jstl8">jstl8</a> </td>
					<td> <a href="./jstl9">jstl9</a> </td>
					<td> <a href="./jstl10">jstl10</a> </td>
					<td> <a href="./jstl11">jstl11</a> </td>
				</tr>
				<tr>
					<td><a href="./boardhome"> 게시판 관련 홈페이지</a> </td>
					<td><a href="./dynamicboard/home"> 동적 게시판 홈페이지</a> </td>
					
					<td><a href="./board/free/list"> board free</a> </td>
					
					<td><a href="./newboard/home"> 새로운 new 게시판 홈페이지</a> </td>
				</tr>
			</table>
		</div>
	</body>
</html>









