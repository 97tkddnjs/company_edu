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
<script src="//cdn.ckeditor.com/4.20.1/standard/ckeditor.js"></script>
</head>
<body>
	<div class="container">
		<script type="text/javascript">
		$(document).ready(function() {
			$("#writeBtn").click(function() {
				if($.trim( $("#title").val() ) == "" ) {
					alert("제목을 입력해 주세요.");
					return; // 수행 중지
				}
				if($.trim( $("#writer").val() ) == "" ) {
					alert("작성자를 입력해 주세요.");
					return; // 수행 중지
				}
				// 내용을 공백으로 입력해도 소스상에서 공백이 아니라서 판별 불가
				if( CKEDITOR.instances.contents.getData() == "" ) {
					alert("내용을 입력해 주세요.");
					return; // 수행 중지
				}
				
				let form = new FormData( document.getElementById("form1") ); // getElementsByName 비교
				form.append("cnts", CKEDITOR.instances.contents.getData() );
				
				for (let item of form.entries()) {
                     console.log(item[0] + " : " + item[1]);
                }
				
				
				// Javascript 객체로 전달해야해서
				$.ajax({
					type:"POST"
					, encType:"multipart/form-data"
					, url:"${pageContext.request.contextPath}/file12/upload5"
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
					} //call back function
					, error : function(xhr) {
						alert("통신 실패");
					} //call back function
				}); // ajax

			}); // click
		}); // ready
		</script>
		<h2>ajax file upload test</h2>
		<form id="form1">
			<table class="table table-hover">
				<tr>
					<th>제목</th>
					<td><input type="text" id="title" name="title" class="form-control" maxlength="50"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" id="writer" name="writer" class="form-control" maxlength="20"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea id="contents" name="contents" class="form-control" maxlength="500"></textarea></td>
					<script type="text/javascript">
					CKEDITOR.replace("contents");
					</script>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" id="addFile" name="addFile" class="form-control"></td>
				</tr>
			</table>
			<button type="button" id="writeBtn" class="btn btn-primary">글 작성 완료</button>
			<button type="button" id="restTestBtn" class="btn btn-warning">REST Test</button>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#restTestBtn").click(function(){
				let board = {	title : $("#title").val()
						, writer : $("#writer").val()
						, pwd : $("#pwd").val()
						, cnts : CKEDITOR.instances.contents.getData()
				};//javascript object 생성
				alert( JSON.stringify( board ) );

				$.ajax({
					type : "POST"
						, url : "${pageContext.request.contextPath}/rest2"
						, data : JSON.stringify( board )
						, processData : false
						, contentType : "application/json"
						, cache : false
						, success : function( result ) {
							alert(result);
						}
						, fail : function( xhr ) {
							alert("fail");
						}
				});//ajax
				
			});//click
			
		})	
		
	</script>
</body>
</html>