<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/adminlist.css">
<link rel="stylesheet" href="css/adminsearch.css">
<script>
	function btn_click() {
		alert("관리자는 탈퇴가 불가능합니다!");
	}
</script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 회원관리 |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="sidemenu.jsp" />

		<div id="content">
			<form action="memberSearch.do" method="post">
				<select name="how">
					<option value="아이디">아이디</option>
					<option value="이름">이름</option>
				</select>&nbsp; <input type="text" size="20" name="obj" required> <input type="submit" value="검색">
			</form>

			<br>

			<table class="tab1">
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>성별</th>
					<th width="180px">이메일</th>
					<th>가일일자</th>
					<th>회원탈퇴</th>
				</tr>

				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.id}</td>
						<td>${dto.pw}</td>
						<td>${dto.name}</td>
						<td>${fn:substring(dto.birth, 0,10)}</td>
						<td>${dto.gender}</td>
						<td>${dto.eMail}</td>
						<td>${fn:substring(dto.rDate, 0,16)}</td>
						<td><c:choose>
								<c:when test="${dto.id eq 'admin'}">
									<input type="button" value="탈퇴불가" onclick="btn_click();">
								</c:when>

								<c:otherwise>
									<input type="button" value="탈퇴" onclick="javascript:location.href='memberDelete.do?id=${dto.id}'">
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</table>

			<table class="tab2">
				<tr>
					<td align="center"><c:forEach var="i" begin="1" end="${tot}">
							<a href="memberList.do?memberPage=${i}">${i}</a>
						</c:forEach></td>
				</tr>

			</table>
		</div>
	</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>