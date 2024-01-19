<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <h3>상세 보기</h3>
		<table class="tg mx-auto">
            <thead>
              <tr>
                <th class="tg-7btt">년도</th>
                <th class="tg-7btt">학기</th>
                <th class="tg-7btt">교과목명</th>
                <th class="tg-7btt">학점</th>
                <th class="tg-7btt">점수</th>
              </tr>
            </thead>
            <c:set var = "credit_sum" value="0" />
            <c:set var = "score_sum" value="0" />
            <tbody>
            	<c:set var = "sum" value="0" />
                <c:forEach varStatus="status" var="score" items="${scores}">
                <tr>
	                <c:if test="${fn:contains(score.score, 'A')}"> 
	                	<c:set var="sum" value="4" />
	  				</c:if>
	                <c:if test="${fn:contains(score.score, 'A+')}"> 
	                	<c:set var="sum" value="4.5" />
	  				</c:if>
	                <c:if test="${fn:contains(score.score, 'B')}"> 
	                	<c:set var="sum" value="3" />
	  				</c:if>
	                <c:if test="${fn:contains(score.score, 'B+')}"> 
	                	<c:set var="sum" value="3.5" />
	  				</c:if>
	                <c:if test="${fn:contains(score.score, 'C')}"> 
	                	<c:set var="sum" value="2" />
	  				</c:if>
	                <c:if test="${fn:contains(score.score, 'C+')}"> 
	                	<c:set var="sum" value="2.5" />
	  				</c:if>
	                <c:if test="${fn:contains(score.score, 'D')}"> 
	                	<c:set var="sum" value="1" />
	  				</c:if>
	                <c:if test="${fn:contains(score.score, 'D+')}"> 
	                	<c:set var="sum" value="1.5" />
	  				</c:if>
	                <c:if test="${fn:contains(score.score, 'F')}"> 
	                	<c:set var="sum" value="0" />
	  				</c:if>
	  				
                    <c:set var = "credit_sum" value = "${credit_sum + score.credit}" />
                    <c:set var = "score_sum" value = "${score_sum + (sum*score.credit)}" />
                    <td class="tg-${status.index%2}"><c:out value="${score.year}"/></td>
                    <td class="tg-${status.index%2}"><c:out value="${score.semester}"/></td>
                    <td class="tg-${status.index%2}"><c:out value="${score.subject}"/></td>
                    <td class="tg-${status.index%2}"><c:out value="${score.credit}"/></td>
                    <td class="tg-${status.index%2}"><c:out value="${score.score}"/></td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
             <tr>
                <td class="tg-52bx">총계</td>
                <td class="tg-52bx"> </td>
                <td class="tg-52bx"> </td>
                <td class="tg-52bx"><c:out value ="${credit_sum}"/></td>
                <td class="tg-52bx"><fmt:formatNumber type="number"  pattern="0.00" value="${score_sum/credit_sum}" /></td>
             </tr>
            </tfoot>
        </table>
   </div>
   
</body>
</html>