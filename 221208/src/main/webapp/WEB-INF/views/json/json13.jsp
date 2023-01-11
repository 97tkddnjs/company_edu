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
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn1").click(function(){
				$.get(
					"${pageContext.request.contextPath}/json13return",
					{},
					// data와 상태를 나타내는 status
					function(data,status){
						//alert(data);
						$("#tbody1").empty();
						
						$.each(data,function(index, dto){
							
							$("#tbody1").append( //append
									"<tr>"
									+"<td>"+dto.empno +"</td>"
									+"<td>"+dto.ename +"</td>"
									+"<td>"+dto.job +"</td>"
									+"<td>"+dto.mgr +"</td>"
									+"<td>"+dto.hiredate +"</td>"
									+"<td>"+dto.sal +"</td>"
									+"<td>"+dto.comm +"</td>"
									+"<td>"+dto.deptno +"</td>"
									+"</tr>"
								);
							
						}); // each
					},
					"json"
				);// get
			});//click
		}); 
	</script>
	<button id="btn1" class ="btn btn-warning"> Select Emp All </button>
	<hr>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>사번</th> 	<th>이름</th> 	<th>직업</th> 	<th>부서장 사번</th> 
				<th>입사일</th> 	<th>급여</th> 	<th>상여금 </th> 	<th>부서 번호</th>
			</tr>
		</thead>
		<tbody id="tbody1">
		</tbody>
	</table>
</body>
</html>