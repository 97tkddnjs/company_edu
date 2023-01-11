<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>json12 </title>
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
					 "${pageContext.request.contextPath}/json12return",
					 //, {} 보내는 데이터가 없다면 쓰지 않아도 된다.
					 function(data, status){
						 $("#movie_tbody").empty();
						 //alert(data);
						 // 분해할 데이터 , 처리할 함수
						 $.each(data, function(index, dto){
							//alert(index);
							//alert(dto);
							//alert(dto.movieName);
							$("#movie_tbody").append(
								"<tr>"
								+"<td>"+dto.movieName +"</td>"
								+"<td>"+dto.mainActor +"</td>"
								+"<td>"+dto.mainActorRole +"</td>"
								+"</tr>"
							);
						 });
						
					 }
					 ,"json" // 4번째가 json임
			 )
		 })
		 
	 }); // click
	</script>
	<button id="btn1">Call Json</button>
	<table class="table table-hover"> 
		<thead>
			<tr><td>영화 제목 </td><td>주연 배우</td><td>주연 배우 역할</td></tr>
		</thead>
		<tbody id="movie_tbody"></tbody>
	</table>

</body>
</html>