<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
		<a>| �������� |</a>
	</div>

	<main>
	<form action="boardModifyOk.do" method="post">
		<input type="hidden" name="wNum" value="${view.wNum}">

		<table>
			<tr>
				<th>���̵�</th>
				<td id="id">${view.wId}</td>
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
		<a href="boardList.do"><input type="button" value="���" id="cancelbtn"></a>
	</form>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>