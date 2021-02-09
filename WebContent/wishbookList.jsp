<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/adminlist.css">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 희망도서관리 |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="sidemenu.jsp" />

		<div id="content">
			<table class="tab1" style="margin-top:130px">
				<tr>
					<th>No.</th>
					<th>도서명</th>
					<th>저자</th>
					<th>출판사</th>
					<th>발행년</th>
					<th>신청일</th>
					<th>등록</th>
					<th>반려</th>
				</tr>

				<c:forEach items="${list}" var="dto" varStatus="status">
					<input type="hidden" name="wbNum" value="${dto.wbNum}">
					<tr>
						<td>${fn:length(list) - status.index}</td>
						<td>${dto.wbName}</td>
						<td>${dto.wbWriter}</td>
						<td>${dto.wbPublish}</td>
						<td>${dto.wbYear}</td>
						<td>${fn:substring(dto.wbDate, 0,10)}</td>
						<td width="70"><a href="wishbookAddForm.do?wbNum=${dto.wbNum}"><input type="button" value="등록"></a></td>
						<td width="70"><a href="wishbookDelete.do?wbNum=${dto.wbNum}"><input type="button" value="반려" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>