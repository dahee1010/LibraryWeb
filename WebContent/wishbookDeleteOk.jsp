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
		<c:when test="${empty ri}">
			<script>
				location.href = document.referrer;
			</script>
		</c:when>

		<c:when test="${ri eq '0'}">
			<script>
				alert('�ý��� ����');
				history.back();
			</script>
		</c:when>

		<c:when test="${ri eq '1'}">
			<script>
				alert('�ݷ��Ǿ����ϴ�.');
				location.href = document.referrer;
			</script>
		</c:when>
	</c:choose>
</body>
</html>