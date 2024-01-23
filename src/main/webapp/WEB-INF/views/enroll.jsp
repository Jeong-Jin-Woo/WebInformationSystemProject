<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <title>subject check page</title>
    <style>
        .container {
            max-width: 50%;
        }

        .form-group {
            margin-bottom: 0;
        }

        .btn-submit {
            margin-top: 0;
        }

        .row.justify-content-left {
            margin-left: -5px;
            margin-right: -5px;
        }

        .col-md-2,
        .col-md-1,
        .col-md-2 {
            padding-left: 5px;
            padding-right: 5px;
        }

        .col-md-1 {
            padding-right: 0; /* Adjusted to remove right padding for the '분반' input */
        }

        .btn-submit {
            margin-left: -5px; /* Adjusted to remove left margin for the '신청' button */
        }
    </style>
</head>
<body>
    <jsp:include page="menu.jsp" />

    <div class="container text-center">
        <br>
        <h3>수강 신청하기</h3>
			<sf:form action="${pageContext.request.contextPath}/doenroll" method="post" modelAttribute="enroll">
			<div class="row justify-content-center">
		        <div class="col-md-2">
		            <div class="form-group">
		                <sf:input type="text" maxlength="10" class="form-control form-control-sm" placeholder="과목 코드" path="class_id"></sf:input>
		            </div>
		        </div>
		        <div class="col-md-1">
		            <div class="form-group">
		                <sf:input type="text" maxlength="1" class="form-control form-control-sm" placeholder="분반" path="division"></sf:input>
		            </div>
		        </div>
		        <div class="col-md-1">
		        	<input type="hidden" name="stu_name" value="${pageContext.request.userPrincipal.name}" />
		            <button class="btn btn-primary btn-submit">신청</button>
		        </div>
		    </div>
		</sf:form>

            
    </div>
	<c:forEach var="enroll" items="${enrolls}">
		<p> <c:out value="${enroll}" /> </p>
	</c:forEach>

</body>
</html>
