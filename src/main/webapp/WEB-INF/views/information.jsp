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
			<h1>�� �л� ����</h1>
            <p>
            <br>
            <br>
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <a href="${pageContext.request.contextPath}/information/semester?name=${pageContext.request.userPrincipal.name}" class="btn btn-secondary">�б⺰ �̼� ���� ��ȸ &raquo;</a> <!-- score -->
                </div>
            </div>
            <p>
            <br>
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <a href="${pageContext.request.contextPath}/enroll" class="btn btn-info btn-lg">���� ��û�ϱ� &raquo;</a>
                </div>
            </div>
            <p>
            <br>
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <a href="${pageContext.request.contextPath}/check" class="btn btn-warning btn-lg">���� ��û ��Ȳ ��ȸ &raquo;</a>
                </div>
            </div>
		</div>
</body>
</html>