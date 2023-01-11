<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="kr.co.kico.newboard.SessionConst"  %>
<%@ page import="kr.co.kico.newboard.dto.MemberDTO"  %>


<html>
<head>
	<title>DynamicHome</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</head>
<body>
		
		<%@ include file="/WEB-INF/views/newboard/navbar.jsp" %>
		<div class="container">
			<h1>
				
				board control Page  
			</h1>
			<P>  The time on the server is ${serverTime}. </P>
			
			<table class="table table-hover">
				<thead>
					<tr>
						<td> 순번 </td>
						<td> 메뉴 이름</td>
						<td> 게시판 이름 </td>
						<td> 게시물 이름 </td>
						<td> 작성자 </td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="test" items="${allboardlist}" varStatus="status">
						<tr>
							<td> ${status.count}  </td>
							<td> ${test.menu_type_name} </td>
							<td> ${test.board_name}  </td>
							<td> <a href ="${pageContext.request.contextPath}/newboard/admin/${test.menu_type_name}/${test.board_name}/${test.board_id} } ">${test.bname}</a>
							 </td>
							<td> ${test.member_login_id}</td>
						</tr>
					</c:forEach>
				
				</tbody>
				
				
				
			</table>
			
		</div>
	</body>
</html>









