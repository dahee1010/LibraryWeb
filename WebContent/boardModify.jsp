<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/board.css">
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 공지사항 |</a>
	</div>

	<main>
	<form action="boardModifyOk.do" method="post">
		<input type="hidden" name="wNum" value="${view.wNum}">
		<c:set var="content1" value="${view.content}"/>

		<table>
			<tr>
				<th>아이디</th>
				<td id="id">${view.wId}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${view.title}" required></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="60" rows="10" name="content" required>${fn:replace(content1, '<br>', "&#10;")}</textarea></td>
			</tr>
		</table>

		<input type="submit" value="작성" id="writebtn">
		<a href="boardList.do"><input type="button" value="취소" id="cancelbtn"></a>
	</form>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>