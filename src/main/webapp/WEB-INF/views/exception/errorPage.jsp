<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HTTP ERROR ${code}</title>
</head>
<body>
	<h1>HTTP ${code} 오류</h1>
	<div style='padding:10px; border:1px solid black; border-radius:5px;'>
		<p>${msg}</p>
		<%-- <p>${ex.message}</p>
		<c:forEach items="${ex.stackTrace}" var="ste">    
			${ste} 
   		</c:forEach> --%>
	</div>
</body>
</html>