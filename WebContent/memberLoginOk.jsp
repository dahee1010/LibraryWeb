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

		<c:when test="${empty id}">
			<script>
				alert('아이디를 입력하세요!');
				document.location.href = "memberLogin.jsp";
			</script>
		</c:when>

		<c:when test="${empty pw}">
			<script>
				alert('비밀번호를 입력하세요!');
				document.location.href = "memberLogin.jsp";
			</script>
		</c:when>

		<c:when test="${checkNum eq '0'}">
			<script>
				alert('비밀번호가 다릅니다!');
				document.location.href = "memberLogin.jsp";
			</script>
		</c:when>

		<c:when test="${checkNum eq '-1'}">
			<script>
				alert('회원이 아닙니다!');
				document.location.href = "memberLogin.jsp";
			</script>
		</c:when>

		<c:otherwise>
			<%
				String id = request.getParameter("id");
						session.setAttribute("id", id);
						session.setAttribute("ValidMem", "yes");
						response.sendRedirect("main.do");
			%>
		</c:otherwise>

	</c:choose>

</body>
</html>