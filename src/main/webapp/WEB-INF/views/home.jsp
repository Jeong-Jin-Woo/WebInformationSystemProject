<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<title>Home</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<p>
		<a href="${pageContext.request.contextPath}/offers">전체 회원 정보 보기</a>

		
		<div class="container text-center">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <a href="${pageContext.request.contextPath}/informationLists" class="btn btn-info btn-lg">교과목 조회 &raquo;</a>
                </div>
            </div>
		<c:if test="${pageContext.request.userPrincipal.name != null}"> 
            <p>
            <br>
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <a href="${pageContext.request.contextPath}/information" class="btn btn-warning btn-lg">학사 정보 조회 &raquo;</a>
                </div>
            </div>
		</c:if>
		</div>
		
</body>
</html>

