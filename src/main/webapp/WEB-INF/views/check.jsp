<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<style>
.container {
	display: flex;
	justify-content: space-between;
	max-width: 90%;
	margin: auto;
}

.left-container {
	width: 35%;
}

.right-container {
	width: 60%;
}

.form-group {
	margin-bottom: 0px;
}

.btn-submit {
	margin-top: 0px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

th {
	background-color: #409cff;
	color: white;
}

.tg {
	border-collapse: collapse;
	border-color: #9ABAD9;
	border-spacing: 0;
}

.tg td {
	text-align: center;
	background-color: #EBF5FF;
	border-bottom-width: 1px;
	border-color: #9ABAD9;
	border-style: solid;
	border-top-width: 1px;
	border-width: 0px;
	color: #444;
	font-family: Arial, sans-serif;
	font-size: 14px;
	overflow: hidden;
	padding: 9px 20px;
	word-break: normal;
}

.tg th {
	text-align: center;
	background-color: #409cff;
	border-bottom-width: 1px;
	border-color: #9ABAD9;
	border-style: solid;
	border-top-width: 1px;
	border-width: 0px;
	color: #fff;
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	overflow: hidden;
	padding: 9px 20px;
	word-break: normal;
}

.tg .tg-7btt {
	border-color: inherit;
	font-weight: bold;
	text-align: center;
	vertical-align: top
}

.tg .tg-0 {
	background-color: #D2E4FC;
	border-color: inherit;
	text-align: center;
	vertical-align: top
}

.tg .tg-1 {
	text-align: center;
	vertical-align: top
}

.tg .tg-52bx {
	background-color: #ffffff;
	color: #000000;
	border-color: inherit;
	font-weight: bold;
	text-align: center;
	vertical-align: top;
	border-bottom: 1px solid black;
}

.col-md-1 {
	padding-right: 0;
	/* Adjusted to remove right padding for the '분반' input */
}

.btn-submit {
	margin-left: -5px;
	/* Adjusted to remove left margin for the '신청' button */
}

.row.justify-content-left {
	margin-left: -5px;
	margin-right: -5px;
}

.col-md-2, .col-md-1, .col-md-2 {
	padding-left: 5px;
	padding-right: 5px;
}

.btn.btn-sm.btn-success {
	margin: 0;
}
</style>
<title>subject check page</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<br>
	<div class="container">
	<h3>수강 신청 현황 조회</h3>
	</div>
	<div class="container text-center">
		<div class="container">
			<table class="tg mx-auto">
				<thead>
					<tr>
						<th class="tg-fymr">과목코드</th>
						<th class="tg-fymr">과목명</th>
						<th class="tg-fymr">분반</th>
						<th class="tg-fymr">담당교수</th>
						<th class="tg-fymr">강의실</th>
						<th class="tg-fymr">학점</th>
					</tr>
				</thead>
				<c:set var="credit_sum" value="0" />
				<tbody>
					<c:forEach varStatus="status" var="enroll" items="${enrolls}">
						<tr>
							<c:set var="credit_sum" value="${credit_sum + enroll.credit}" />
							<td class="tg-${status.index%2}"><c:out
									value="${enroll.class_id}" /></td>
							<td class="tg-${status.index%2}"><c:out
									value="${enroll.title}" /></td>
							<td class="tg-${status.index%2}"><c:out
									value="${enroll.division}" /></td>
							<td class="tg-${status.index%2}"><c:out
									value="${enroll.professor}" /></td>
							<td class="tg-${status.index%2}"><c:out
									value="${enroll.room}" /></td>
							<td class="tg-${status.index%2}"><c:out
									value="${enroll.credit}" /></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td class="tg-52bx"></td>
						<td class="tg-52bx"></td>
						<td class="tg-52bx"></td>
						<td class="tg-52bx"></td>
						<td class="tg-52bx">총 학점</td>
						<td class="tg-52bx"><c:out value="${credit_sum}" /></td>
					</tr>
				</tfoot>
			</table>
		</div>

	</div>
</body>
</html>