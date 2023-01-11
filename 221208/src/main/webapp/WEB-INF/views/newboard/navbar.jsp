<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="kr.co.kico.newboard.NavBar"  %>
<%@ page import="kr.co.kico.newboard.SessionConst"  %>
<%@ page import="kr.co.kico.newboard.dto.MemberDTO"  %>
<%@ page session="false" %>

<%
					HttpSession session = request.getSession();
					MemberDTO  dto = (MemberDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
					
%>
<c:set var="val" value="<%=dto %>" />
<nav class="navbar navbar-expand-lg bg-light">
		
		  <div class="container-fluid">
		  <c:choose>
		  	<c:when test="${val.member_grade_id eq 1}">
		  		<a class="navbar-brand" href="/kico/newboard/admin/home">Admin Home</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
		  	</c:when>
		  	<c:otherwise>
		  		<a class="navbar-brand" href="/kico/newboard/home">Home</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
		  	</c:otherwise>
		  </c:choose>
		    
		    
		    
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto me-auto me-auto">
		        
		        
		       	
		        <c:choose>
		        	
		        	<c:when test="${not empty val}">
		       			 <li class="nav-item">
		          			<a class="nav-link" href="/kico/newboard/logout">log out</a>
		       			 </li>
		        		
		        		
		        	</c:when>
		        	<c:otherwise>
		        		<li class="nav-item">
		          			<a class="nav-link" href="/kico/newboard/login">log in</a>
		       			 </li>
		        	</c:otherwise>
		        </c:choose>
		       
		        
		        
		        
		        
		        
		        
		         <c:forEach var="meunlist" items="${list}" varStatus="status">
		         	<li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#"  data-bs-toggle="dropdown" aria-expanded="false">
			            ${meunlist.menu_type_name}
			          </a>
			          <ul class="dropdown-menu">
			          	<c:forEach var="board" items="${boardlist}" varStatus="sta">
			          		
			          		<c:if test="${meunlist.menu_type_id eq board.menu_type_id}">
			          			<li><a class="dropdown-item" href="/kico/newboard/${meunlist.menu_type_name}/${board.board_name}/${board.board_id}"> ${board.board_name}</a></li>
			          		</c:if>
			          	</c:forEach>
			          </ul>
			        </li>
		         	
		        </c:forEach>
		        
		        
		        <li class="nav-item">
		          <a class="nav-link disabled">no</a>
		        </li>
		       
		      </ul>
		      <form class="d-flex" role="search">
		        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
		        <button class="btn btn-outline-success" type="submit">Search</button>
		      </form>
		    </div>
		  </div>
		</nav>