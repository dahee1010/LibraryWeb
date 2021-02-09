<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bookview.css">
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/star.css">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 도서상세 |</a>
	</div>

	<main>
	<c:if test="${sessionScope.id eq null}">
		<jsp:forward page="memberLogin.jsp" />
	</c:if>

	<div class="box1">

		<!-- 도서 상세정보 -->
		<form action="mybookAdd.do" method="post">
			<input type="hidden" name="bookNum" value="${view.bookNum}">
			<input type="hidden" name="bookName" value="${view.bookName}">
			<input type="hidden" name="writer" value="${view.writer}">
			<input type="hidden" name="bCnt" value="${view.bCnt}">
			<input type="hidden" name="cnt" value="${view.cnt}">
			<input type="hidden" name="bookimg" value="${view.bookimg}">

			<table>
				<tr>
					<td rowspan="6" width="300px">
					<c:choose>
							<c:when test="${empty view.bookimg}">
								<img src="bookimg/booknull.jpg" width="225px" height="325px"/>
							</c:when>

							<c:when test="${not empty view.bookimg}">
								<img src="${view.bookimg}" width="225px" height="325px"/>
							</c:when>
						</c:choose>
						</td>
					<th colspan="2">${view.bookName}</th>
				</tr>

				<tr>
					<td width="100px"><b>저자</b></td>
					<td colspan="2">${view.writer}</td>
				</tr>

				<tr>
					<td><b>출판사</b></td>
					<td>${view.publish}</td>
				</tr>

				<tr>
					<td><b>발행년도</b></td>
					<td>${view.year}</td>
				</tr>

				<tr>
					<td><b>청구기호</b></td>
					<td>${view.code}</td>
				</tr>

				<tr>
					<td><b>대출횟수</b></td>
					<td>${view.cnt}/${view.bCnt}</td>

				</tr>

			</table>

			<input type="submit" value="대출하기">
		</form>
	</div>


	<div class="box2">
		<span>북리뷰</span> 전체 <a>${fn:length(review)}개</a>의 리뷰가 등록되어 있습니다.
		<hr>

		<!-- 리뷰남기는 폼 -->
		<form action="reviewWrite.do" method="post">
			<input type="hidden" name="bookNum" value="${view.bookNum}">
			<table>

				<tr>
					<th width="100px">평점</th>
					<td>
						<fieldset class="rating">
							<input type="radio" id="star5" name="rating" value="5"/>
							<label class="full" for="star5" title="5stars"></label>
							<input type="radio" id="star4" name="rating" value="4" />
							<label class="full" for="star4" title="4stars"></label>
							<input type="radio" id="star3" name="rating" value="3" />
							<label class="full" for="star3" title="3stars"></label>
							<input type="radio" id="star2" name="rating" value="2" />
							<label class="full" for="star2" title="2stars"></label>
							<input type="radio" id="star1" name="rating" value="1" />
							<label class="full" for="star1" title="1stars"></label>
						</fieldset>
					</td>
				</tr>

				<tr>
					<td colspan="2"><textarea cols="60" rows="5" name="rContent" required></textarea></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="등록" id="writebtn" /></td>
				</tr>

			</table>
		</form>
	</div>

	<div class="box3">
		<!-- 리뷰 목록 -->

		<table>
			<c:forEach items="${review}" var="dto">
				<tr>
					<td width="130px"><c:choose>
							<c:when test="${dto.rating eq '1'}">
								<img src="css/1star.png" alt="1점" width="130px">
							</c:when>

							<c:when test="${dto.rating eq '2'}">
								<img src="css/2star.png" alt="2점" width="130px">
							</c:when>

							<c:when test="${dto.rating eq '3'}">
								<img src="css/3star.png" alt="3점" width="130px">
							</c:when>

							<c:when test="${dto.rating eq '4'}">
								<img src="css/4star.png" alt="4점" width="130px">
							</c:when>

							<c:when test="${dto.rating eq '5'}">
								<img src="css/5star.png" alt="5점" width="130px">
							</c:when>
						</c:choose> <br> 작성자 : ${dto.rId}</td>

					<td id="content">${dto.rContent}</td>

					<td width="60px"><c:choose>
							<c:when test="${id eq dto.rId}">
								<a href="reviewDelete.do?rNum=${dto.rNum}&rId=${dto.rId}"><input type="button" value="삭제" id="deletebtn" /></a>
							</c:when>

							<c:when test="${id ne dto.rId}"></c:when>
						</c:choose></td>

				</tr>
			</c:forEach>
		</table>
	</div>

	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>