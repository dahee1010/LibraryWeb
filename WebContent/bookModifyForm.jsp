<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/bookadmin.css">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 도서수정 |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="sidemenu.jsp" />

		<form action="bookModifyOk.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="bookNum" value="${view.bookNum}">
			<input type="hidden" name="bookimg1" value="${view.bookimg}">
			<table>

				<tr>
					<th>도서명</th>
					<td><input type="text" name="bookName" size="50" value="${view.bookName}" required></td>
				</tr>
				<tr>
					<th>저자명</th>
					<td><input type="text" name="writer" size="50" value="${view.writer}" required></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input type="text" name="publish" size="50" value="${view.publish}" required></td>
				</tr>
				<tr>
					<th>발행년도</th>
					<td><input type="text" name="year" size="50" value="${view.year}" required pattern="^(18|19|20)\d{2}$" title="형식: 숫자로 된 연도 4자리"></td>
				</tr>
				<tr>
					<th>청구기호</th>
					<td><input type="text" name="code" size="50" value="${view.code}" required></td>
				</tr>
				<tr>
					<th>보유재고</th>
					<td><input type="text" name="bCnt" size="50" value="${view.bCnt}" required pattern="^[0-9]*$" title="형식: 숫자"></td>
				</tr>
				<tr>
					<th>도서사진</th>
					<td><input type="file" name="bookimg2" size="40"><br>
					<c:choose>
							<c:when test="${empty view.bookimg}">
								null
							</c:when>

							<c:when test="${not empty view.bookimg}">
								${view.bookimg}
							</c:when>
						</c:choose>
					</td>
				</tr>
			</table>

			<input type="submit" value="작성" id="writebtn"> <a href="bookListAdmin.do"><input type="button" value="취소" id="cancelbtn"></a>
		</form>

	</div>
	</main>

	<jsp:include page="footer.jsp" />
	
</body>
</html>