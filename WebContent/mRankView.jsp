<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table class="tab1">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>대출권수</td>
		</tr>

		<c:forEach items="${rank}" var="dto" varStatus="status">
			<tr>
				<td><c:out value="${status.count}" /></td>
				<td>${dto.id}</td>
				<td>${dto.cnt}권</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>