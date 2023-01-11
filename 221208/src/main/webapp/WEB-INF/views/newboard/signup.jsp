<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title> sign up </title>
</head>
	<body>
		<script type="text/javascript">
			
			$(document).ready(function() {
				$("#signup_btn").click(function(){
					alert("in")
					if($.trim( $("#member_login_id").val() ) == "" ) {
						alert("아이디를 입력해 주세요.");
						return; // 수행 중지
					}
					
					if($.trim( $("#member_pwd").val() ) == "" ) {
						alert("비번을 입력해 주세요.");
						return; // 수행 중지
					}
					
					
					// Javascript 객체로 전달해야해서
					$.ajax({
						type:"POST"
						//, encType:"multipart/form-data"
						, url:"${pageContext.request.contextPath}/newboard/signup"
						, data : {
							member_login_id : $("#member_login_id").val(),
							member_pwd :  $("#member_pwd").val()
							}
						//, processData : false
						//, contentType : false // < - 이거 땜에 안갈 수 있음
						, cache : false
						, success : function(result) {
							if(result > 0) {
								alert(result)
								alert("회원가입 성공");
							} else {
								alert(result)
								alert("회원가입 실패 \n 관리자에게 문의 바랍니다");
							}	
							location.href='/kico/newboard/home';
						} //call back function
						, error : function(xhr) {
							alert(xhr)
							alert("통신 실패");
						} //call back function
					}); // ajax
					
				})// click
				
			})// ready
		
		</script>
	
		<div class="container">
			<form id="signup_form" > 
				아이디 : <input type="text" id="member_login_id" name="member_login_id" class="form-control">
				
				패스워드 : <input type="password" id="member_pwd" name="member_pwd" class="form-control">
				<br>
				<button type="button" id="signup_btn" class="btn btn-primary"> sign up </button>
				<button type="button" onclick="location.href='./home'" class="btn btn-warning"> cancel </button>
			</form>
			<hr>
		</div>
	</body>
</html>