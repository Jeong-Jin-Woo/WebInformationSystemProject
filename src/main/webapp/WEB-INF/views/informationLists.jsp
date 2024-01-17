<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
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
</style>
<meta charset="EUC-KR">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<title>subject check page</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
   <div class="container text-center">
        <h3>시간표 및 교과목 조회</h3>
		<table class="tg mx-auto">
			<thead>
				<tr>
					<th class="tg-fymr">년도</th>
					<th class="tg-fymr">학기</th>
					<th class="tg-fymr">과목코드</th>
					<th class="tg-fymr">과목명</th>
					<th class="tg-fymr">담당교수</th>
					<th class="tg-fymr">분반</th>
					<th class="tg-fymr">강의실</th>
					<th class="tg-fymr">학점</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="status" var="informationList" items="${informationLists}">
				<tr>
					<td class="tg-${status.index%2}"><c:out value="${informationList.year}"/></td>
					<td class="tg-${status.index%2}"><c:out value="${informationList.semester}"/></td>
					<td class="tg-${status.index%2}"><c:out value="${informationList.course_id}"/></td>
					<td class="tg-${status.index%2}"><c:out value="${informationList.title}"/></td>
					<td class="tg-${status.index%2}"><c:out value="${informationList.name}"/></td>
					<td class="tg-${status.index%2}"><c:out value="${informationList.division}"/></td>
					<td class="tg-${status.index%2}"><c:out value="${informationList.classroom}"/></td>
					<td class="tg-${status.index%2}"><c:out value="${informationList.credit}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>