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
			alert('���̵� �̹� �����մϴ�.');
			history.back();
			</script>
		</c:when>
	
		<c:when test="${ri eq '0'}">
			<script>
				alert('ȸ�����Կ� �����߽��ϴ�.');
				history.back();
			</script>
		</c:when>

		<c:when test="${ri eq '1'}">
			<script>
				alert('ȸ�������� �����մϴ�.');
				document.location.href = "memberLogin.jsp";
				</script>
				</c:when>

	</c:choose>
</body>
</html>