<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />

<style type="text/css">
.tg  {border-collapse:collapse;border-color:#aaa;border-spacing:0;}
.tg td{background-color:#fff;border-bottom-width:1px;border-color:#aaa;border-style:solid;border-top-width:1px;
  border-width:0px;color:#333;font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:9px 20px;
  word-break:normal;}
.tg th{background-color:#f38630;border-bottom-width:1px;border-color:#aaa;border-style:solid;border-top-width:1px;
  border-width:0px;color:#fff;font-family:Arial, sans-serif;font-size:14px;font-weight:normal;overflow:hidden;
  padding:9px 20px;word-break:normal;}
.tg .tg-1{text-align:center;vertical-align:top}
.tg .tg-0{background-color:#FCFBE3;border-color:inherit;text-align:center;vertical-align:top}
.tg .tg-7btt{border-color:inherit;font-weight:bold;text-align:center;vertical-align:top}
.tg .tg-52bx{background-color:#cb0000;color:#ffffff;border-color:inherit;font-weight:bold;text-align:center;vertical-align:top}
</style>
<title>subject check page</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
   <div class="container text-center">
        <br>
        <h3>학기별 이수 학점 조회</h3>
		<table class="tg mx-auto">
            <thead>
              <tr>
                <th class="tg-7btt">년도</th>
                <th class="tg-7btt">학기</th>
                <th class="tg-7btt">취득 학점</th>
                <th class="tg-7btt">상세보기</th>
              </tr>
            </thead>
            <c:set var = "row_sum" value="0" />
            <tbody>
                <c:forEach varStatus="status" var="semester" items="${semesters}">
                <tr>
                    <c:set var = "row_sum" value = "${row_sum + semester.credit}" />
                    <td class="tg-${status.index%2}"><c:out value="${semester.year}"/></td>
                    <td class="tg-${status.index%2}"><c:out value="${semester.semester}"/></td>
                    <td class="tg-${status.index%2}"><c:out value="${semester.credit}"/></td>
                    <td class="tg-${status.index%2}"><a href="${pageContext.request.contextPath}/information/semester/score?name=${pageContext.request.userPrincipal.name}&year=${semester.year}&semester=${semester.semester}">링크</a></td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
             <tr>
                <td class="tg-52bx">총계</td>
                <td class="tg-52bx"> </td>
                <td class="tg-52bx"><c:out value ="${row_sum}"/></td>
                <td class="tg-52bx"> </td>
             </tr>
            </tfoot>
        </table>
   </div>
        
</body>
</html>
