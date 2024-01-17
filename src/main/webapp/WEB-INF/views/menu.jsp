<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>

        <div class="ml-auto">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <a href="${pageContext.request.contextPath}/login" class="btn btn-sm btn-success">로그인</a>
                <a href="${pageContext.request.contextPath}/createoffer" class="btn btn-sm btn-success">회원가입</a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                ${offer.name} <a href="javascript:document.getElementById('logout').submit()" class="btn btn-danger">로그아웃</a>
            </c:if>
        </div>

        <form id="logout" action="<c:url value="/logout" />" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </div>
</nav>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
