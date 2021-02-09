<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/hearderfooter.css">
<link rel="stylesheet" href="css/mainsearch.css">
<link rel="stylesheet" href="css/mainbox.css">
<link rel="stylesheet" href="css/tab.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script language="JavaScript" src="check.js" charset="utf-8"></script>
<script>
	$(document).ready(function() {

		$('ul.tabs li').click(function() {
			var tab_id = $(this).attr('data-tab');

			$('ul.tabs li').removeClass('current');
			$('.tab-content').removeClass('current');

			$(this).addClass('current');
			$("#" + tab_id).addClass('current');
		})

	})
</script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<main> <c:if test="${sessionScope.id eq null}">
		<jsp:forward page="memberLogin.jsp" />
	</c:if>

	<section>
		<jsp:include page="mainImage.jsp" />
	</section>


	<div class="parent">
		<div class="searchform">
			<form action="bookSearch.do" method="post" name="search_frm">
				<div class="select">
					<select name="how">
						<option value="제목">제목</option>
						<option value="저자">저자</option>
						<option value="출판사">출판사</option>
					</select>
				</div>

				<div class="text">
					<input type="text" size="20" name="obj" placeholder="검색어를 입력해주세요.">
				</div>

				<div class="search">
					<input type="button" value="검색" onclick="searchConfirm()">
				</div>
			</form>
		</div>
	</div>

	<div id="board">
		<div id="left">
			<h2>독서왕랭킹</h2>
			<table>
				<c:forEach items="${memberrank}" var="dto" varStatus="status">
					<tr>
						<td><c:out value="${status.count}" />등</td>
						<td>${dto.id}</td>
						<td>${dto.cnt}권</td>
					</tr>
				</c:forEach>
			</table>

		</div>

		<div id="right">
			<h2>
				공지사항<a href="boardList.do"><span>＋</span></a>
			</h2>
			<table>
				<c:forEach items="${boardlist}" var="dto" varStatus="status" begin="0" end="4" step="1">
					<tr>
						<td align="left" width="600px" id="title"><a href="boardView.do?wNum=${dto.wNum}">${dto.title}</a></td>
						<td id="date">${fn:substring(dto.wDate, 0,10)}</td>
					</tr>
				</c:forEach>
			</table>
		</div>


		<div class="container">

			<ul class="tabs">
				<li class="tab-link current" data-tab="tab-1">신착도서</li>
				<li class="tab-link" data-tab="tab-2">베스트셀러</li>
				<li class="tab-link" data-tab="tab-3">추천도서</li>
			</ul>

			<div id="tab-1" class="tab-content current">
				<!-- 신착도서 -->
				<table>
					<tr>
						<c:forEach items="${list}" var="dto" varStatus="status" begin="0" end="4" step="1">
							<td><c:choose>
									<c:when test="${empty dto.bookimg}">
										<a href="bookView.do?bookNum=${dto.bookNum}"><img src="bookimg/booknull.jpg" width="180px" height="270px" /></a>
									</c:when>

									<c:when test="${not empty dto.bookimg}">
										<a href="bookView.do?bookNum=${dto.bookNum}"><img src="${dto.bookimg}" width="180px" height="270px" /></a>
									</c:when>
								</c:choose></td>
						</c:forEach>
					</tr>

					<tr>
						<c:forEach items="${list}" var="dto" varStatus="status" begin="0" end="4" step="1">
							<td><a href="bookView.do?bookNum=${dto.bookNum}">${dto.bookName}</a> <br> <span>${dto.writer}</span></td>
						</c:forEach>
					</tr>
				</table>
			</div>

			<div id="tab-2" class="tab-content">
				<!-- 베스트셀러 -->
				<table>
					<tr>
						<c:forEach items="${bookrank}" var="dto" varStatus="status" begin="0" end="4" step="1">
							<td><c:choose>
									<c:when test="${empty dto.bImg}">
										<a href="bookView.do?bookNum=${dto.bNum}"><img src="bookimg/booknull.jpg" width="180px" height="270px" /></a>
									</c:when>

									<c:when test="${not empty dto.bImg}">
										<a href="bookView.do?bookNum=${dto.bNum}"><img src="${dto.bImg}" width="180px" height="270px" /></a>
									</c:when>
								</c:choose></td>
						</c:forEach>
					</tr>

					<tr>
						<c:forEach items="${bookrank}" var="dto" varStatus="status" begin="0" end="4" step="1">
							<td>
							 <a style="color: #fb4448">${status.count}위.</a>
							<a href="bookView.do?bookNum=${dto.bNum}">${dto.bName}</a> <br> <span>${dto.bWriter}</span>
							</td>
						</c:forEach>
					</tr>
				</table>
			</div>

			<div id="tab-3" class="tab-content">
				<!-- 추천도서 -->
				<table>
					<tr>
						<c:forEach items="${randombook}" var="dto" varStatus="status" begin="0" end="4" step="1">
							<td><c:choose>
									<c:when test="${empty dto.bookimg}">
										<a href="bookView.do?bookNum=${dto.bookNum}"><img src="bookimg/booknull.jpg" width="180px" height="270px" /></a>
									</c:when>

									<c:when test="${not empty dto.bookimg}">
										<a href="bookView.do?bookNum=${dto.bookNum}"><img src="${dto.bookimg}" width="180px" height="270px" /></a>
									</c:when>
								</c:choose></td>
						</c:forEach>
					</tr>

					<tr>
						<c:forEach items="${randombook}" var="dto" varStatus="status" begin="0" end="4" step="1">
							<td><a href="bookView.do?bookNum=${dto.bookNum}">${dto.bookName}</a> <br> <span>${dto.writer}</span></td>
						</c:forEach>
					</tr>
				</table>
			</div>
		</div>
	</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</body>
</html>