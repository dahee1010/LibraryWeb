<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/calendar.css">
<link rel="stylesheet" href="css/courselist.css">
<script language="javascript">
	function win_op(mypage, myname, w, h, scroll) {
		var winl = (screen.width - w) / 2;
		var wint = (screen.height - h) / 2;
		winprops = 'height=' + h + ',width=' + w + ',top=' + wint + ',left='
				+ winl + ',scrollbars=' + scroll + ',resizable'
		win = window.open(mypage, myname, winprops)
		if (parseInt(navigator.appVersion) >= 4) {
			win.window.focus();
		}
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 문화강좌 |</a>
	</div>

	<main>

	<div id="course">

		<div id="info">
			<table>
				<tr>
					<td><a href="courseView.do?yy=${yy}&mm=${mm}&action=0">◀</a></td>
					<td>${yy}년 ${mm+1}월</td>
					<td><a href="courseView.do?yy=${yy}&mm=${mm}&action=1">▶</a></td>
				</tr>
			</table>
		</div>
		<table id="calendar">
			<tr>
				<th style="color: red;">일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th style="color: blue;">토</th>
			</tr>

			<c:set var="j" value="0"></c:set>
			<c:set var="i" value="1"></c:set>

			<c:forEach var="j" begin="1" end="${weekSize}" step="1">
				<tr>

					<c:forEach var="i" begin="1" end="7" step="1">
						<td><c:if test="${(oneDayNum eq i or day>1) and (day<endDay+1)}">
								<c:choose>
									<c:when test="${i%7 eq '1'}">
										<div id="day" style="color: red;">${day}</div>
										<br>
									</c:when>

									<c:when test="${i%7 eq '0'}">
										<div id="day" style="color: blue;">${day}</div>
										<br>
									</c:when>

									<c:otherwise>
										<div id="day">${day}</div>
										<br>
									</c:otherwise>
								</c:choose>

								<div id="conten">
									<c:set var="day" value="${day+1}" />
									<c:forEach items="${course}" var="dto" varStatus="status">
										<c:if test="${dto.day + 1 == day}">

											<a href="#">ㆍ${dto.lecName}</a>
											<br>

										</c:if>

									</c:forEach>
								</div>
							</c:if></td>

					</c:forEach>
				</tr>
			</c:forEach>
		</table>

		<table class="tab1">
			<tr>
				<th>구분</th>
				<th width="350px">강좌명</th>
				<th width="150px">강사명</th>
				<th>대상</th>
				<th>날짜</th>
				<th>강의시간</th>
			</tr>

			<c:forEach items="${course}" var="dto" varStatus="status">
				<tr>
					<td>${dto.category}</td>
					<td align="left">${dto.lecName}</td>
					<td>${dto.instruc}</td>
					<td>${dto.object}</td>
					<td>${dto.year}.${dto.month}.${dto.day}</td>
					<td>${dto.startTime} ~ ${dto.endTime}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>