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
			<td>��ȣ</td>
			<td>���̵�</td>
			<td>����Ǽ�</td>
		</tr>

		<c:forEach items="${rank}" var="dto" varStatus="status">
			<tr>
				<td><c:out value="${status.count}" /></td>
				<td>${dto.id}</td>
				<td>${dto.cnt}��</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>