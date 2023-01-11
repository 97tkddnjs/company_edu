<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form3.jsp</title>
</head>
<body>

	<h1> file upload test 1 : 파일 전송</h1>
	<form	action="${pageContext.request.contextPath}/file11/upload1"
			method = "post" enctype="multipart/form-data">
		<div class="form-inline">
			<input type="file" class ="form-control" name="fileFromJsp1">
			<button type="submit">file upload</button>
		</div>
	</form>
	<hr>
	
	
	
	<hr>
		<h1> file upload test 2 : 파일 전송 + 쓰기 </h1>
	<form	action="${pageContext.request.contextPath}/file11/upload2"
			method = "post" enctype="multipart/form-data">
		<div class="form-inline">
			<input type="file" class ="form-control" name="fileFromJsp1">
			<button type="submit">file upload</button>
		</div>
	</form>
	
	
	<h1> file upload test 3 : 파일 전송 + 쓰기 + 날짜 폴더 + 시분 파일명 </h1>
	<form	action="${pageContext.request.contextPath}/file11/upload3"
			method = "post" enctype="multipart/form-data">
		<div class="form-inline">
			<input type="file" class ="form-control" name="fileFromJsp1">
			<button type="submit">file upload</button>
		</div>
	</form>
	
	
	<h1> file upload test 4 : 파일 전송 + 쓰기 + 날짜 폴더 + 시분 파일명 + DTO 활용 </h1>
	<form	action="${pageContext.request.contextPath}/file11/upload4"
			method = "post" enctype="multipart/form-data">
		<div class="form-inline">
			<input type="file" class ="form-control" name="fileFromJsp1">
			<button type="submit">file upload</button>
		</div>
		test text : <input type="text" name ="testInput" value="this is test text">
	</form>
	<hr>
	
	
</body>
</html>