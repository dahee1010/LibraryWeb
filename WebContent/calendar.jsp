<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="css/calendar.css">
<title>Insert title here</title>

</head>
<body>
	<table>
		<tr id="table1">
			<td><a href="calendar.do?yy=${yy}&mm=${mm}&action=0">◀</a></td>
			<td>${yy}년${mm+1}월</td>
			<td><a href="calendar.do?yy=${yy}&mm=${mm}&action=1">▶</a></td>
		</tr>
	</table>

	<table id="calendar">
		<tr>
			<th>일</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th>토</th>
		</tr>

		<c:set var="j" value="0"></c:set>
		<c:set var="i" value="1"></c:set>

		<c:forEach var="j" begin="1" end="${weekSize}" step="1">
			<tr>

				<c:forEach var="i" begin="1" end="7" step="1">
					<td><c:if test="${(oneDayNum eq i or day>1) and (day<endDay+1)}">
					<div id="day">${day}</div>
					<c:set var="day" value="${day+1}" />
							<c:forEach items="${cal}" var="dto" varStatus="status">
								<c:if test="${dto.day + 1 == day}">
									<div id="conten"><a href="#">${dto.content}</div>
								</c:if>
							</c:forEach>
						</c:if></td>

				</c:forEach>
			</tr>
		</c:forEach>

	</table>

</body>
</html>