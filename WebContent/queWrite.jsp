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
		<a>| Q&A |</a>
	</div>

	<main>
	
	<form action="queWrite.do" method="post">
		<input type="hidden" name="id" value="${id}">
		
		<table>
			<tr>
				<th>아이디</th>
				<td id="id">&nbsp;${id}</td>
			</tr>
			<tr>
				<th>공개여부</th>
				<td>
				&nbsp;
				<input type="radio" name="open" value="true">
				<span>공개</span> &nbsp;
				<input type="radio" name="open" value="false">
				<span>비공개</span>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" required></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="60" rows="10" name="content" required></textarea></td>
			</tr>
		</table>

		<input type="submit" value="작성" id="writebtn">
		<a href="queList.do"><input type="button" value="취소" id="cancelbtn"></a>	
	</form>
	
	</main>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>