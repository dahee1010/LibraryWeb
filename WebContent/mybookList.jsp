<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/mybooklist.css">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 내서재 |</a>
	</div>

	<main> <c:choose>

		<c:when test="${empty list}">
			<img src="css/mybooknull.png" alt="booknull.img" width="45%" />
		</c:when>

		<c:otherwise>
			<span>* 반납일자가 초과된 항목은 자동으로 삭제됩니다.</span>
			<table>
				<tr>
					<th>No.</th>
					<th>도서명</th>
					<th>저자</th>
					<th>대출일자</th>
					<th>반납일자</th>
					<th>상태</th>
				</tr>

				<c:forEach items="${list}" var="dto" varStatus="status">
					<tr>
						<td>${fn:length(list) - status.index}</td>
						<td>${dto.mbName}</td>
						<td>${dto.mbWriter}</td>
						<td>${fn:substring(dto.mbDate, 0,10)}</td>
						<td>${fn:substring(dto.mbRdate, 0,10)}</td>
						<td width="110px">
						<c:choose>
						<c:when test="${dto.exten eq '0'}">
						<a href="mybookExten.do?mbNum=${dto.mbNum}"> <input type="button" value="연장" /></a>
						<a href="mybookDelete.do?mbNum=${dto.mbNum}&bNum=${dto.bNum}"> <input type="button" value="반납" /></a>
						</c:when>
							
						<c:when test="${dto.exten eq '1'}">
						<a href="mybookDelete.do?mbNum=${dto.mbNum}&bNum=${dto.bNum}"> <input type="button" value="반납" /></a>
						</c:when>
						</c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>

		</c:otherwise>
	</c:choose> </main>
	<jsp:include page="footer.jsp" />

</body>
</html>