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
		<a>| �������� |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="sidemenuMember.jsp" />

		<form action="memberModifyOk.do" method="post">

			<table>
				<tr>
					<th>���̵�</th>
					<td>${view.id}</td>
				</tr>
				<tr>
					<th>�̸�</th>
					<td><input type="text" name="name" value="${view.name}"
						required></td>
				</tr>
				<tr>
					<th>�������</th>
					<fmt:parseDate var="birthFormat" value="${view.birth}"
						pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate var="birthEx" value="${birthFormat}"
						pattern="yyMMdd" />
					<td><input type="text" name="birth" value="${birthEx}"
						required
						pattern="[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1])"
						title="����: yymmdd"></td>
				</tr>
				<tr>
					<th>����</th>
					<td>
					<c:choose>
							<c:when test="${view.gender eq 'man'}">
								<input type="radio" name="gender" value="man" checked>
								<span>����</span> &nbsp;
								<input type="radio" name="gender" value="woman">
								<span>����</span>
							</c:when>

							<c:when test="${view.gender eq 'woman'}">
								<input type="radio" name="gender" value="man">
								<span>����</span> &nbsp;
								<input type="radio" name="gender" value="woman" checked>
								<span>����</span>
							</c:when>
						</c:choose>
						</td>
				</tr>
				<tr>
					<th>�̸���</th>
					<td><input type="text" name="eMail" value="${view.eMail}"></td>
				</tr>
			</table>

			<input type="submit" value="Ȯ��" id="writebtn">
		</form>
	</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>