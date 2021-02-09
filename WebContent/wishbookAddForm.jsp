<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/bookadminview.css">
<script language="JavaScript" src="check.js" charset="utf-8"></script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 희망도서등록 |</a>
	</div>

	<main>
	
		<div id="admin">
		<jsp:include page="sidemenu.jsp" />
		
	<form action="wishbookAdd.do" method="post" enctype="multipart/form-data">

		<c:forEach items="${list}" var="dto">
			<input type="hidden" name="wbNum" value="${dto.wbNum}">
			<input type="hidden" name="wbName" value="${dto.wbName}">
			<input type="hidden" name="wbWriter" value="${dto.wbWriter}">
			<input type="hidden" name="wbPublish" value="${dto.wbPublish}">
			<input type="hidden" name="wbYear" value="${dto.wbYear}">


			<table>
				<tr>
					<th>도서명</th>
					<td>${dto.wbName}</td>
				</tr>
				<tr>
					<th>저자명</th>
					<td>${dto.wbWriter}</td>
				</tr>
				<tr>
					<th>출판사</th>
					<td>${dto.wbPublish}</td>
				</tr>
				<tr>
					<th>발행년도</th>
					<td>${dto.wbYear}</td>
				</tr>
				<tr>
					<th>청구기호</th>
					<td><input type="text" name="code" size="40" required placeholder="부여할 청구기호를 입력해주세요."></td>
				</tr>
				<tr>
					<th>보유재고</th>
					<td><input type="text" name="bCnt" size="40" required placeholder="보유재고를 입력해주세요." pattern="^[0-9]*$" title="형식: 숫자"></td>
				</tr>
				<tr>
					<th>도서사진</th>
					<td><input type="file" name="file" size=40></td>
				</tr>
			</table>

		</c:forEach>
		<input type="submit" value="추가" id="writebtn">
		<a href="wishbookList.do"><input type="button" value="취소" id="cancelbtn2"></a>

	</form>
	</div>
	</main>
</body>
</html>