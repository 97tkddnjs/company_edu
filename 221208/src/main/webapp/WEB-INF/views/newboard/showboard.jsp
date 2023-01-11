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
		
		
		<script type="text/javascript">
			function callUpload(){
				let value = '${val.getMember_login_id() }';

				if(value=='' || value==null)
					alert('회원만 가능합니다.');
				else{
					location.href='${pageContext.request.contextPath}/newboard/${menutype}/${boardname}/${board_id}/boardupload';
				}
					
					//if()
					/*
					$.ajax({
						type:"GET"
						//, encType:"multipart/form-data"
						, url:"${pageContext.request.contextPath}/newboard/${menutype}/${ boardname}/boardupload"
						//, data : form
						//, processData : false
						//, contentType : false
						//, cache : false
						, success : function(result) {
							
							alert(result)
							//location.href="./dynamicboard/home";
						} //call back function
						, error : function(xhr) {
							alert(xhr)
							alert("통신 실패");
						} //call back function
					}); // ajax
					*/
			}
		
		
		</script>
		
		<div class="container">
			<h1>
				
				${menutype} menu ${ boardname} 게시판  Page  
			</h1>
			<P>  write your word. </P>
			
			<table class="table table-hover">
				<thead>
					<tr>
						<td>순번</td>
						<td>게시물 제목</td>
						<td>작성자</td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty detailboard}">
						<c:forEach var="test" items="${detailboard}" varStatus="status">
							<tr>
								<td> ${status.count}  </td>
								<td><a href="${pageContext.request.contextPath}/newboard/${test.menu_type_name}/${test.board_name}/${test.bseq}/detail">${test.bname}</a></td>
								<td> ${test.member_login_id}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
				
				
				
				<c:if test="${empty detailboard}">
					<h2>게시글이 없습니다~</h2>
				</c:if>
				
			</table>
			
			
			
			<c:out value="${val.getMember_login_id() }"></c:out>
			
			<button id ="write-board"class="btn btn-primary" type="button" 
			style="float: right;" onclick = "callUpload()" > hi</button>
			<!--onclick="location.href='${pageContext.request.contextPath}/newboard/${menutype}/${ boardname}/boardupload'"-->
			
		</div>
	</body>
</html>









