<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="container">
		<script type="text/javascript">
			/*
			$(document).ready(function() {
				$("#writeBtn").click(function() {
				if($.trim( $("#bname").val() ) == "" ) {
					alert("제목을 입력해 주세요.");
					return; // 수행 중지
				}
				// 내용을 공백으로 입력해도 소스상에서 공백이 아니라서 판별 불가
				if( CKEDITOR.instances.cnts.getData() == "" ) {
					alert("내용을 입력해 주세요.");
					return; // 수행 중지
				}
				
				let form = new FormData( document.getElementById("form1") ); // getElementsByName 비교
				form.append("cnts", CKEDITOR.instances.cnts.getData() );
				
				for (let item of form.entries()) {
	                    console.log(item[0] + " : " + item[1]);
	            }
				
				
				
				// Javascript 객체로 전달해야해서
				
				$.ajax({
					type:"POST"
					//, encType:"multipart/form-data"
					, url:"${pageContext.request.contextPath}/newboard/${menu_type_name}/${board_name}/${board_id}/boardupload"
					, data : form
					, processData : false
					, contentType : false
					, cache : false
					, success : function(result) {
						if(result=="")
							alert("yes");
						if(result > 0) {
							alert(result)
							alert("게시글 작성 성공");
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
				
				
				
				
			}); // click
		}); // ready
		*/
		</script>
		<h2>member update</h2>
		<form id="form1">
			<table class="table table-hover">
				<tr>
					<th>member login id</th>
					<td><input type="text" id="member_login_id" name="member_login_id" class="form-control" maxlength="50" value="${member.member_login_id}" readonly></td>
				</tr>
				<tr>
					<th>member pwd</th>
					<td><input type="text" id="member_pwd" name="member_pwd" class="form-control" value="${member.member_pwd}" readonly></td>
				</tr>
				<tr>
					<th>멤버 그룹</th>
					<td>
					<select name = "menu_type_id">
						<option  value="1">member</option>
					</select>
					</td>
				</tr>
			</table>
			
			<button type="button" id="writeBtn" class="btn btn-primary">멤버  update</button>
			<button type="button"  class="btn btn-secondary" onclick="history.back()">취소하기</button>
		</form>
	</div>
</body>
</html>