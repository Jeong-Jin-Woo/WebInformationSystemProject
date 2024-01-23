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
    .tg  {border-collapse:collapse;border-color:#9ABAD9;border-spacing:0;}
.tg td{background-color:#EBF5FF;border-bottom-width:1px;border-color:#9ABAD9;border-style:solid;border-top-width:1px;
  border-width:0px;color:#444;font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:9px 20px;
  word-break:normal;}
.tg th{background-color:#409cff;border-bottom-width:1px;border-color:#9ABAD9;border-style:solid;border-top-width:1px;
  border-width:0px;color:#fff;font-family:Arial, sans-serif;font-size:14px;font-weight:normal;overflow:hidden;
  padding:9px 20px;word-break:normal;}
.tg .tg-7btt{border-color:inherit;font-weight:bold;text-align:center;vertical-align:top}
.tg .tg-0{background-color:#D2E4FC;border-color:inherit;text-align:center;vertical-align:top}
.tg .tg-1{text-align:center;vertical-align:top}
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
    
		<table class="tg mx-auto">
			<thead>
				<tr>
					<th class="tg-fymr">과목코드</th>
					<th class="tg-fymr">과목명</th>
					<th class="tg-fymr">분반</th>
					<th class="tg-fymr">담당교수</th>
					<th class="tg-fymr">강의실</th>
					<th class="tg-fymr">학점</th>
					<th class="tg-fymr">신청 취소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="status" var="enroll" items="${enrolls}">
				<tr>
					<td class="tg-${status.index%2}"><c:out value="${enroll.class_id}"/></td>
					<td class="tg-${status.index%2}"><c:out value="${enroll.title}"/></td>
					<td class="tg-${status.index%2}"><c:out value="${enroll.division}"/></td>
					<td class="tg-${status.index%2}"><c:out value="${enroll.professor}"/></td>
					<td class="tg-${status.index%2}"><c:out value="${enroll.room}"/></td>
					<td class="tg-${status.index%2}"><c:out value="${enroll.credit}"/></td>
					<td class="tg-${status.index%2}"> 
					  <a href="${pageContext.request.contextPath}/enroll/delete?stu_name=${enroll.stu_name}&class_id=${enroll.class_id}" class="btn btn-danger">&times;</a></td>
				
					<!--<a href="${pageContext.request.contextPath}/enroll/delete?enroll=${enroll}" class="btn btn-danger">&times;</a></td>-->
				
				</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>
