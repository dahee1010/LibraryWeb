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
		<a>| Q&A |</a>
	</div>

	<main>

	<table class="tab1">
		<tr>
			<th>No.</th>
			<th width="650px">제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>처리상태</th>
		</tr>

		<c:forEach items="${list}" var="dto" varStatus="status">
			<tr>
				<td>${cnt - ((pagenum-1) * pageBlock + status.index)}</td>
				<td align="left">
				<c:choose>
					<c:when test="${dto.open eq 'false'}">
					<img src="css/lock.png" id="lock"/>
					<a href="queViewCheck.do?qNum=${dto.qNum}" style="margin-left: 23px">&nbsp;&nbsp;${dto.title}</a>
					</c:when>
					
					<c:otherwise>
					<a href="queViewCheck.do?qNum=${dto.qNum}">&nbsp;&nbsp;${dto.title}</a>
					</c:otherwise>
				</c:choose>
				</td>
				<td>${dto.qId}</td>
				<td>${fn:substring(dto.qDate, 0,10)}</td>
				<td>
				<c:choose>
					<c:when test="${dto.cnt eq '0'}">처리중</c:when>
					<c:otherwise>답변완료</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
		
	</table>

	<a href="queWrite.jsp"><input type="button" value="글작성"></a>



	<table class="tab2">
		<tr>
			<td align="center"><c:if test="${startPage > pageBlock}">
					<a href="queList.do?page=1">[맨앞으로]</a>
					<a href="queList.do?page=${startPage-10}">[이전]</a>
				</c:if> <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
					<a href="queList.do?page=${i}">${i}</a>
				</c:forEach> <c:if test="${endPage < pageCount}">

					<a href="queList.do?page=${startPage+10}">[다음]</a>
					<a href="queList.do?page=${pageCount}">[맨뒤로]</a>
				</c:if></td>
		</tr>
	</table>
	</main>
	<jsp:include page="footer.jsp" />
</body>
</html>