<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<title>회원가입</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">회원가입</h1>
		</div>
	</div>
	<div class="container" align="center">
		<div class="col-md-4 col-md-offset-4">
			<sf:form class="form-signin" action="${pageContext.request.contextPath}/docreate" method="post" modelAttribute="offer">
			
				<div class="form-group">
					<label for="inputUserName" class="sr-only">User Name</label>
					<sf:input type="text" class="form-control" placeholder="Name" path="name"></sf:input>
					<sf:errors style = "color:red" path="name"/>
				</div>
				
				<div class="form-group">
					<label for="inputUserEmail" class="sr-only">User Email</label>
					<sf:input type="text" class="form-control" placeholder="Email" path="email"></sf:input> 
					<sf:errors style = "color:red" path="email"/>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="sr-only">Password</label> 
					<sf:input type="password" class="form-control" placeholder="Password" path="password"></sf:input> 
					<sf:errors style = "color:red" path="password"/>
				</div>
				
				<button class="btn btn btn-lg btn-success btn-block" type="submit">회원가입</button>
			</sf:form>
		</div>
	</div>
</body>
</html>