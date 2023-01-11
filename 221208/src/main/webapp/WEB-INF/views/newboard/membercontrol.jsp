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
		<script type="text/javascript">
		
		function upBtnClick(index) {
			//alert("${pageContext.request.contextPath}");
			
			//alert($("#upbtn"+index).text())
			location.href="${pageContext.request.contextPath}/newboard/admin/memberspecific/"+index
			/*
			$.ajax({
				type:"GET"
				//, encType:"multipart/form-data"
				, url:"${pageContext.request.contextPath}/newboard/admin/menudelete"
				, data : {
					
					menu_type_name : $("#rmvbtn"+index).text(),
				}
				
				//, processData : false
				//, contentType : false
				//, cache : false
				, success : function(result) {
					alert("123");
					location.href="${pageContext.request.contextPath}/newboard/admin/menuadd";
				
				} //call back function
				
				, error : function(request,status,error) {
					alert("통신 실패");
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				} //call back function
				
			}); // ajax
			
			*/
		}
		</script>
		
		
		<%@ include file="/WEB-INF/views/newboard/navbar.jsp" %>
		<div class="container">
			<h1>
				
				member control Page  
			</h1>
			
			<table class="table table-hover">
				<thead>
					<tr>
						<td> 순번 </td>
						<td> 회원 아이디 </td>
						<td> 그룹 id </td>
						<td> 관리 등급 id </td>
						<td> update </td>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="test" items="${memberlist}" varStatus="status">
						<tr>
							<td> ${status.count}  </td>
							<td> ${test.member_login_id}  </td>
							<td> ${test.member_group_id}</td>
							<td> ${test.member_grade_id}</td>
							<td> <button type="button" 
										id ="upbtn${status.index}"  onclick="upBtnClick(${test.member_id});">${test.member_id} update</button></td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
			
		</div>
	</body>
</html>









