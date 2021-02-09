<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/board.css">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| Q&A |</a>
	</div>

	<main>

	<form action="queModifyOk.do" method="post">
		<input type="hidden" name="qNum" value="${view.qNum}">

		<table>
			<tr>
				<th>���̵�</th>
				<td id="id">&nbsp;${view.qId}</td>
			</tr>
			<tr>
				<th>��������</th>
				<td>
				&nbsp;
				<c:choose>
						<c:when test="${view.open eq 'true'}">
							<input type="radio" name="open" value="true" checked>
							<span>����</span> &nbsp;
							<input type="radio" name="open" value="false">
							<span>�����</span>
						</c:when>
							
						<c:when test="${view.open eq 'false'}">
							<input type="radio" name="open" value="true">
							<span>����</span> &nbsp;
							<input type="radio" name="open" value="false" checked>
							<span>�����</span>
						</c:when>
				</c:choose>
				</td>
			</tr>
			<tr>
				<th>����</th>
				<td><input type="text" name="title" value="${view.title}" required></td>
			</tr>
			<tr>
				<th>����</th>
				<td><textarea cols="60" rows="10" name="content" required>${view.content}</textarea></td>
			</tr>
		</table>

		<input type="submit" value="�ۼ�" id="writebtn">
		<a href="queList.do"><input type="button" value="���" id="cancelbtn"></a>
	</form>
	
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>