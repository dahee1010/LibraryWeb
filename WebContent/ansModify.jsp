<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/qnaview.css">
<link rel="stylesheet" href="css/qna.css">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| Q&A |</a>
	</div>

	<main>


	<table>
		<tr>
			<th colspan=6 id="title">Q. ${view.title}</th>
		</tr>

		<tr>
			<th>작성자</th>
			<td>${view.qId}</td>
			<th>등록일</th>
			<td>${fn:substring(view.qDate, 0,16)}</td>
		</tr>
		<tr>
			<td colspan=6 id="content">${view.content}</td>
		</tr>
	</table>

	<form action="ansModifyOk.do" method="post">
		<c:set var="content1" value="${ans.content}" />

		<input type="hidden" name="qNum" value="${view.qNum}"> <input type="hidden" name="qtitle" value="${view.title}">
		<table style="margin-top: 50px">
			<tr>
				<th>답변내용</th>
				<td><textarea cols="60" rows="10" name="content" required>${fn:replace(content1, '<br>', "&#10;")}</textarea></td>
			</tr>
		</table>

		<input type="submit" value="작성" id="writebtn"> <a href="queView.do?qNum=${view.qNum}"><input type="button" value="취소" id="cancelbtn"></a>
	</form>

	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>