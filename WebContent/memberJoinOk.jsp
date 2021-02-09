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
	
	<c:when test="${confirmId eq '1'}">
			<script>
			alert('아이디가 이미 존재합니다.');
			history.back();
			</script>
		</c:when>
	
		<c:when test="${ri eq '0'}">
			<script>
				alert('회원가입에 실패했습니다.');
				history.back();
			</script>
		</c:when>

		<c:when test="${ri eq '1'}">
			<script>
				alert('회원가입을 축하합니다.');
				document.location.href = "memberLogin.jsp";
				</script>
				</c:when>

	</c:choose>
</body>
</html>