<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/boardlist.css">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 공지사항 |</a>
	</div>

	<main>

	<table class="tab1">
		<tr>
			<th>No.</th>
			<th width="800px">제목</th>
			<th>조회</th>
			<th>등록일</th>
		</tr>

		<c:forEach items="${boardlist}" var="dto" varStatus="status">
			<tr>
				<td>${cnt - ((pagenum-1) * pageBlock + status.index)}</td>
				<td align="left"><a href="boardView.do?wNum=${dto.wNum}">&nbsp;&nbsp;${dto.title}</a></td>
				<td>${dto.hit}</td>
				<td>${fn:substring(dto.wDate, 0,10)}</td>
			</tr>
		</c:forEach>
	</table>

	<c:if test="${id eq 'admin'}">
		<a href="boardWrite.jsp"><input type="button" value="글작성"></a>
	</c:if> <c:if test="${id ne 'admin'}"></c:if>


	<table class="tab2">
		<tr>
			<td align="center"><c:if test="${startPage > pageBlock}">
					<a href="boardList.do?page=1">[맨앞으로]</a>
					<a href="boardList.do?page=${startPage-10}">[이전]</a>
				</c:if> <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
					<a href="boardList.do?page=${i}">${i}</a>
				</c:forEach> <c:if test="${endPage < pageCount}">

					<a href="boardList.do?page=${startPage+10}">[다음]</a>
					<a href="boardList.do?page=${pageCount}">[맨뒤로]</a>
				</c:if></td>
		</tr>
	</table>
	</main>

	<jsp:include page="footer.jsp" />
</body>
</html>