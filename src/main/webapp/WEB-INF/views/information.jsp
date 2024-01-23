<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

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
					<sf:form action="${pageContext.request.contextPath}/enroll" method="get" modelAttribute="enroll">
		                <input type="hidden" name="name" value="${pageContext.request.userPrincipal.name}" />
		                <button type="submit" class="btn btn-info btn-lg">���� ��û�ϱ� &raquo;</button>
		            </sf:form>
                </div>
            </div>
            <p>
            <br>
            
            <div class="row">
                <div class="col-md-6 offset-md-3">
				<sf:form action="${pageContext.request.contextPath}/check" method="post" modelAttribute="enroll">
	                <input type="hidden" name="name" value="${pageContext.request.userPrincipal.name}" />
	                <button type="submit" class="btn btn-warning btn-lg">���� ��û ��Ȳ ��ȸ &raquo;</button>
	            </sf:form>
	            </div>
            <!--  
                <div class="col-md-6 offset-md-3">
                    <a href="${pageContext.request.contextPath}/check" class="btn btn-warning btn-lg">���� ��û ��Ȳ ��ȸ &raquo;</a>
                </div>-->
            </div>
            
		</div>
</body>
</html>