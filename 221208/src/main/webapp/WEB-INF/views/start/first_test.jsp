<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First_test</title>
</head>
<body>
	<h1>First_test</h1>
	<h3> ${emp_list}</h3>
	<c:forEach var = "one_dto" items="${emp_list}">
		<hr>
		${one_dto.deptno } 
		${one_dto.comm } 
		${one_dto.deptno } 
		${one_dto.sal } 
		${one_dto.hiredate } 
		${one_dto.mgr }
		${one_dto.job } 
		${one_dto.ename } 
		${one_dto.empno }
	</c:forEach>
</body>
</html>