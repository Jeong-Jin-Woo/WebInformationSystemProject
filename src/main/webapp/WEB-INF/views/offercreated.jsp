<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
${offer.name}이 회원가입을 하였습니다. 감사합니다.
<p> <a href="${pageContext.request.contextPath}/">Go to Home</a>
</body>
</html>