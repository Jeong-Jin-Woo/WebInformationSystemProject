<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<title>subject check page</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
   <div class="container text-center">
        <br>
        <h3>수강 신청 현황 조회</h3>
        
	<c:forEach var="enroll" items="${enrolls}">
		<p> <c:out value="${enroll}" /> </p>
	</c:forEach>
        
   </div>
</body>
</html>