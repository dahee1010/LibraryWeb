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

	<c:when test="${ri eq '0'}">
		<script>
			alert("도서삭제를 실패했습니다.");
			history.back();
		</script>>
		</c:when>

	<c:otherwise>
		<script>
			alert("도서삭제에 성공했습니다.");
			document.location.href = "bookListAdmin.do";
		</script>
	</c:otherwise>

</c:choose>

</body>
</html>