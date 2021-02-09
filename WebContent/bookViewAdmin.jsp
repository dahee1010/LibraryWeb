<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/bookadminpro.css">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 도서관리 |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="sidemenu.jsp" />

		<form action="bookModifyForm.do" method="post">
			<input type="hidden" name="bookNum" value="${view.bookNum}">
			<table>
				<tr>
					<th>도서명</th>
					<td>${view.bookName}</td>
				</tr>
				<tr>
					<th>저자명</th>
					<td>${view.writer}</td>
				</tr>
				<tr>
					<th>출판사</th>
					<td>${view.publish}</td>
				</tr>
				<tr>
					<th>발행년도</th>
					<td>${view.year}</td>
				</tr>
				<tr>
					<th>청구기호</th>
					<td>${view.code}</td>
				</tr>
				<tr>
					<th>보유재고</th>
					<td>${view.bCnt}</td>
				</tr>
				<tr>
					<th>도서사진</th>
					<td><c:choose>
							<c:when test="${empty view.bookimg}">
								<img src="bookimg/booknull.jpg" width="200px" height="290px"></img>
							</c:when>

							<c:when test="${not empty view.bookimg}">
								<img src="${view.bookimg}" width="200px" height="290px"></img>
							</c:when>
						</c:choose>
					</td>
				</tr>
			</table>

			<a href="bookDelete.do?bookNum=${view.bookNum}"><input type="button" value="삭제" id="deletebtn" /></a>
			<input type="submit" value="수정" id="modifybtn">
			<a href="bookListAdmin.do"><input type="button" value="목록" id="cancelbtn" /></a>

		</form>

	</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>