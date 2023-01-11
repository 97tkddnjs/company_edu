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
<h1 align='center'>상세 글 보기</h1>
<div class="container">
	<table class="table table-hover">
		<thead>
		</thead>
		<tbody id="tbody1">
			<tr>
				<th>번호</th> <td> ${detail_dto.bno}  </td>
			</tr>
			<tr>
			<th>제목</th> <td> ${detail_dto.title}  </td>
			</tr>
			<tr>    
				<th>작성자</th> <td> ${detail_dto.writer}  </td>
			</tr>
			<tr>
				<th>내용</th> <td> ${detail_dto.cnts}  </td>
			</tr>
			<tr>
				<th>파일 이름</th> 
				<td>
					
					${detail_dto.add_file_name} 
					</a>
				</td>
			</tr>
			<tr>
				<th>파일 경로</th> 
				<td>
				 <a href="${pageContext.request.contextPath}/file/download?path=${detail_dto.add_file_path}">
				 ${detail_dto.add_file_path}  
				 </td>
			</tr>
			<tr>
				<th>작성 시간</th> <td> ${detail_dto.bdate}  </td>
			</tr>
		</tbody>
	</table>
	<button type="button" id="restTestBtn" class="btn btn-warning">REST Delete Test</button>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$("#restTestBtn").click(function(){
		

		$.ajax({
			type : "DELETE"
				, url : "${pageContext.request.contextPath}/rest2/${detail_dto.bno}"
				, processData : false
				, contentType : false
				, cache : false
				, success : function( result ) {
					alert(result);
				}
				, fail : function( xhr ) {
					alert("fail");
				}
		});//ajax
		
	}) //click
})//ready
</script>

</body>
</body>
</html>