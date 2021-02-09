<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/hearderfooter.css">
</head>
<body>

	<header>
		<div id="header1">

			<div id="logo">
				<a href="main.do"><img src="css/logo.png" alt="메인으로" width="65%"></a>
			</div>

			<div id="top_menu">
				<!-- 첫번째 메뉴 -->
				<c:if test="${id eq 'admin'}">
					<a href="memberList.do">${id}님 안녕하세요.</a>
				</c:if>

				<c:if test="${id ne 'admin'}">
					<a href="memberView.do">${id}님 안녕하세요.</a>
				</c:if>
			　|　<a href="mybookList.do">내서재</a>　|　<a href="memberLogout.jsp">로그아웃</a>
			</div>
		</div>

		<nav>
			<!-- 두번째 메뉴 -->
			<ul>
				<li><a href="bookList.jsp">도서검색　</a></li>
				<li><a href="wishbookForm.jsp">희망도서신청　</a></li>
				<li><a href="boardList.do">공지사항　</a></li>
				<li><a href="queList.do">Q&A　</a></li>
			</ul>
		</nav>

	</header>

</body>
</html>