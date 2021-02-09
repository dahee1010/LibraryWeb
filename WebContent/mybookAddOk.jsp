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
	
	<c:when test="${ri eq '3'}">
			<script>
				alert('대출가능한 권수가 없습니다.');
				history.back();
			</script>
		</c:when>
		
		<c:when test="${ri eq '0'} ">
			<script>
				alert('내서재 추가에 실패했습니다.');
				history.back();
			</script>
		</c:when>

		<c:when test="${ri eq '1'}">
			<script>
				alert('내서재에 추가되었습니다.');
				location.href = document.referrer;
			</script>
		</c:when>
	</c:choose>
</body>
</html>