<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/boardview.css">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 공지사항 |</a>
	</div>

	<main>

	<form action="boardModify.do" method="post">
		<input type="hidden" name="wNum" value="${view.wNum}">

		<table>
			<tr>
				<th colspan=6 id="title">${view.title}</th>
			</tr>

			<tr>
				<th>작성자</th>
				<td>${view.wId}</td>
				<th>등록일</th>
				<td>${fn:substring(view.wDate, 0,16)}</td>
			</tr>
			<tr>
				<td colspan=6 id="content">${view.content}</td>
			</tr>
		</table>

		<c:if test="${id eq 'admin'}">
			<a href="boardDelete.do?wNum=${view.wNum}"><input type="button" value="삭제" id="deletebtn" /></a>
			<input type="submit" value="수정" id="modifybtn">
			<a href="boardList.do"><input type="button" value="목록" id="cancelbtn" /></a>
		</c:if>

		<c:if test="${id ne 'admin'}">
			<a href="boardList.do"><input type="button" value="목록" id="cancelbtn" /></a>
		</c:if>

	</form>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>