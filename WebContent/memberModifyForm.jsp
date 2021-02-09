<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<a>| 정보수정 |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="sidemenuMember.jsp" />

		<form action="memberModifyOk.do" method="post">

			<table>
				<tr>
					<th>아이디</th>
					<td>${view.id}</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${view.name}"
						required></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<fmt:parseDate var="birthFormat" value="${view.birth}"
						pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate var="birthEx" value="${birthFormat}"
						pattern="yyMMdd" />
					<td><input type="text" name="birth" value="${birthEx}"
						required
						pattern="[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1])"
						title="형식: yymmdd"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
					<c:choose>
							<c:when test="${view.gender eq 'man'}">
								<input type="radio" name="gender" value="man" checked>
								<span>남성</span> &nbsp;
								<input type="radio" name="gender" value="woman">
								<span>여성</span>
							</c:when>

							<c:when test="${view.gender eq 'woman'}">
								<input type="radio" name="gender" value="man">
								<span>남성</span> &nbsp;
								<input type="radio" name="gender" value="woman" checked>
								<span>여성</span>
							</c:when>
						</c:choose>
						</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="eMail" value="${view.eMail}"></td>
				</tr>
			</table>

			<input type="submit" value="확인" id="writebtn">
		</form>
	</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>