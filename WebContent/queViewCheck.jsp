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
	<c:choose>
		<c:when test="${view.open eq 'false' and view.qId eq id}">
			<script>
				location.href = 'queView.do?qNum=${view.qNum}';
			</script>
		</c:when>
		
		<c:when test="${view.open eq 'false' and id eq 'admin'}">
			<script>
				location.href = 'queView.do?qNum=${view.qNum}';
			</script>
		</c:when>
		
		<c:when test="${view.open eq 'true'}">
			<script>
				location.href = 'queView.do?qNum=${view.qNum}';
			</script>
		</c:when>

		<c:otherwise>
			<script>
			alert('비밀글입니다.');
			history.back();
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>