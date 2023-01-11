<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>DynamicHome</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
		
		
		<div class="container">
			
			<h1>
				Dynamic board world!  
			</h1>
			<P>  The time on the server is ${serverTime}. </P>
			<form method="post" action="./typein">
				<input type="text"  id="typename" name="typename">
				<button type="submit"> 게시판 추가하기 </button>
			</form>
			<table class="table table-hover">
				<c:if test="${not empty types}">
					<c:forEach var ="type" items="${types}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td> <a href="${pageContext.request.contextPath}/dynamicboard/${type.board_type_num}/${type.board_type_name}">${type.board_type_name} </a> </td>
						</tr>
					</c:forEach>
				
				</c:if>
				
				
			</table>
		</div>
	</body>
</html>









