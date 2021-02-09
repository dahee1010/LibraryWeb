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
<link rel="stylesheet" href="css/adminsearch.css">
<script>
	function btn_click() {
		alert("�����ڴ� Ż�� �Ұ����մϴ�!");
	}
</script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| ȸ������ |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="sidemenu.jsp" />

		<div id="content">
			<form action="memberSearch.do" method="post">
				<select name="how">
					<option value="���̵�">���̵�</option>
					<option value="�̸�">�̸�</option>
				</select>&nbsp; <input type="text" size="20" name="obj" required> <input type="submit" value="�˻�">
			</form>

			<br>

			<table class="tab1">
				<tr>
					<th>���̵�</th>
					<th>��й�ȣ</th>
					<th>�̸�</th>
					<th>�������</th>
					<th>����</th>
					<th>�̸���</th>
					<th>��������</th>
					<th>ȸ��Ż��</th>
				</tr>

				<c:forEach items="${search}" var="dto">
					<tr>
						<td>${dto.id}</td>
						<td>${dto.pw}</td>
						<td>${dto.name}</td>
						<td>${fn:substring(dto.birth, 0,10)}</td>
						<td>${dto.gender}</td>
						<td style="word-break: break-all">${dto.eMail}</td>
						<td>${dto.rDate}</td>
						<td><c:choose>
								<c:when test="${dto.id eq 'admin'}">
									<input type="button" value="Ż��Ұ�" onclick="btn_click();">
								</c:when>

								<c:otherwise>
									<input type="button" value="Ż��" onclick="javascript:location.href='memberDelete.do?id=${dto.id}'">
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>