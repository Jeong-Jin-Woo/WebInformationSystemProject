<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<title>csemall page</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<c:forEach var="offer" items="${offers}">
		<p> <c:out value="${offer}" /> </p>
	</c:forEach>
</body>
</html>