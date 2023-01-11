<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h1 align='center'> 자유 게시판 </h1>
	<div class="container">
	
		<button type='button 'id='write' class='btn btn-primary'
		    onclick="location.href='${pageContext.request.contextPath}/file12/form'" > 글 쓰기</button>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>        <th>제목</th>    <th>rest 제목</th>    <th>작성자</th>    <th>작성 시간</th>
				</tr>
			</thead>
			<tbody id="tbody1">
				<c:forEach var="str" items="${board_list}" varStatus="status">
					<tr>
						<td> ${str.bno}  </td>
						<td>
						<a href="${pageContext.request.contextPath}/board/free/detail?bno=${str.bno}">${str.title} </a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/rest2/boardfree/${str.bno}">
								${str.title} 
							</a>
							
						</td>
						<td> ${str.title}  </td>
						<td> ${str.writer}  </td>
						<td> ${str.bdate}  </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>