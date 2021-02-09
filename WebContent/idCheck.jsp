<%@page import="com.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
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
			<span style="color:#386bc0">사용가능한 아이디 입니다.</span>
		</c:when>

		<c:when test="${ri eq '1'}">
			<span style="color:red">이미 사용중인 아이디 입니다.</span>
		</c:when>
	</c:choose>
	
</body>
</html>