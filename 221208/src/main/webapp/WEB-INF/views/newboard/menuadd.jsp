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
		
		function rmvBtnClick(index) {
			//alert("${pageContext.request.contextPath}");
			alert(index)
			alert($("#rmvbtn"+index).text())
			$.ajax({
				type:"POST"
				//, encType:"multipart/form-data"
				, url:"${pageContext.request.contextPath}/newboard/admin/menudelete"
				, data : {
					
					menu_type_name : $("#rmvbtn"+index).text(),
				}
				
				//, processData : false
				//, contentType : false
				//, cache : false
				, success : function(result) {
					alert("메뉴판이 삭제되었습니다.");
					location.href="${pageContext.request.contextPath}/newboard/admin/menuadd";
				
				} //call back function
				
				, error : function(request,status,error) {
					alert("통신 실패");
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				} //call back function
				
			}); // ajax
		}
		
	
		
		</script>
		
		<%@ include file="/WEB-INF/views/newboard/navbar.jsp" %>
		<div class="container">
			<h1>
				
				Menu board add delete Page  
			</h1>
			
			
			<form method="post" action="./menuadd" >
				<input type="text"  id="menuname" name="menuname">
				<button type="submit"> 메뉴 추가하기 </button>
			</form>
			
			<hr>
					
			<form method="post" action="./boardadd">
				<select name = "menu_type_id">
					<c:forEach var ="type" items="${list}" varStatus="status">
						<option  value="${type.menu_type_id}">${type.menu_type_name}</option>
					</c:forEach>
				</select>
				<input type="text"  id="board_name" name="board_name">
				<button type="submit" id = "plusboard"> 메뉴 하위 게시판 추가하기 </button>
				
			</form>
					

			<table class="table table-hover">
				
				<thead>
					<tr>
						<td>
							순서
						</td>
						<td>
							메뉴
						</td>
						<td>
							수반된 게시물
						</td>
						<td>
						 	메뉴판 삭제
						</td>
					</tr>
				</thead>
				<tbody>
				
				
				</tbody>
			
				<c:forEach var="test" items="${menu_board_list}" varStatus="status">
					<tr>
						<td> ${status.count}  </td>
						<td> <div id="menun">${test.menu_type_name} </div></td>
						<td> ${test.cnt}  </td>
						<td> <button type="button" id ="rmvbtn${status.index}"  onclick="rmvBtnClick(${status.index});">${test.menu_type_name}</button> </button> </td>
					</tr>
				</c:forEach>
				<!-- <button type="button" id ="rmvbtn${status.index}"  onclick="rmvBtnClick(${status.index});">${test.menu_type_name}</button> -->
				
			</table>
			
		</div>
	</body>
</html>









