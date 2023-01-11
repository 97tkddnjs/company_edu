<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/views/newboard/navbar.jsp" %>

<h1 align='center'>상세 글 보기</h1>

<div class="container">
	
	<table class="table table-hover">
		<thead>
		</thead>
		<tbody id="tbody1">
			<tr>
				<th>번호</th> <td> ${board_detail.bseq}  </td>
			</tr>
			<tr>
				<th>메뉴 타입</th> <td> ${board_detail.menu_type_name}  </td>
			</tr>
			<tr>    
				<th>게시판 종류</th> <td> ${board_detail.board_name}  </td>
			</tr>
			<tr>
				<th>게시물 제목</th> <td> ${board_detail.bname}  </td>
			</tr>
			<tr>
				<th>게시물 작성자</th> <td> ${board_detail.member_login_id}  </td>
			</tr>
			<tr>
				<th>게시물 내용</th> <td> ${board_detail.cnts}  </td>
			</tr>
			<tr>
				<th>파일 이름</th> 
				<td>
					
					${board_detail.add_file_name} 
					</a>
				</td>
			</tr>
			<tr>
				<th>파일 경로</th> 
				<td>
				 <a href="${pageContext.request.contextPath}/newboard/download?path=${board_detail.add_file_path}">
				 ${board_detail.add_file_path}  
				 </td>
			</tr>
			<tr>
				<th>작성 시간</th> <td> ${board_detail.bdate}  </td>
			</tr>
		</tbody>
	</table>
	<script type="text/javascript">
	
		function del(){
			alert("${pageContext.request.contextPath}/newboard/${menu_type_name}/${board_name}/${board_detail.bseq}/boarddelete");
			$.ajax({
				type:"POST"
				//, encType:"multipart/form-data"
				, url:"${pageContext.request.contextPath}/newboard/${menu_type_name}/${board_name}/${board_detail.bseq}/boarddelete"
				, data : false
				, processData : false
				, contentType : false
				, cache : false
				, success : function(result) {
					if(result=="")
						alert("yes");
					if(result > 0) {
						alert(result)
						alert('게시물이 삭제되었습니다.');
					} else {
						alert(result)
						alert("게시글 작성 실패 \n 관리자에게 문의 바랍니다");
					}	
					location.href="./";
				} //call back function
				, error : function(xhr) {
					alert(xhr)
					alert("통신 실패");
				} //call back function
			}); // ajax
			
			
			
			//alert('게시물이 삭제되었습니다.');
			
			
		}
	</script>
	<c:if test="${val.member_login_id eq board_detail.member_login_id}">
		
		<button type="button" id="deleteBtn" class="btn btn-warning" onclick="del()" >글 삭제하기</button>
	</c:if>

	<button type="button"  class="btn btn-secondary" onclick="history.back()">취소하기</button>
	
</div>
</body>
</body>
</html>