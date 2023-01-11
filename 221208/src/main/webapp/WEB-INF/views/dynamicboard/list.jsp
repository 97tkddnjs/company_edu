<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세부 게시판</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h1 align='center'> ${name}  게시판 </h1>
	<div class="container">
	
		<button type='button 'id='write' class='btn btn-primary'
		    onclick="location.href='${pageContext.request.contextPath}/dynamicboard/form/${name}'" > 글 쓰기</button>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>        <th>제목</th>        <th>작성자</th>    <th>작성 시간</th>
				</tr>
			</thead>
			<tbody id="tbody1">
				<c:forEach var="str" items="${board_list}" varStatus="status">
					<tr>
						<td> ${status.count}  </td>
						<td> ${str.bname}  </td>
						<td> ${str.writer}  </td>
						<td> ${str.bdate}  </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="button" onclick="location.href='../home'" >홈으로</button>
	</div>
	</body>
</html>