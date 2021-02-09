<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/adminlist.css">
<link rel="stylesheet" href="css/adminsearch.css">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| �������� |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="sidemenu.jsp" />

		<div id="content">
			<form action="bookSearchAdmin.do" method="post">
				<select name="how">
				<option value="����">����</option>
				<option value="����">����</option>
				<option value="���ǻ�">���ǻ�</option>
				</select>&nbsp;<input type="text" size="20" name="obj" required> <input type="submit" value="�˻�">
			</form>
			
			<br>

			<table class="tab1">
				<tr>
					<th width="70px">������ȣ</th>
					<th width="300px">������</th>
					<th width="300px">���ڸ�</th>
					<th>���ǻ�</th>
					<th width="70px">����⵵</th>
				</tr>

				<c:forEach items="${search}" var="dto">
					<tr style="margin: 30px">
						<td>${dto.bookNum}</td>
						<td><a href="bookViewAdmin.do?bookNum=${dto.bookNum}">${dto.bookName}</a></td>
						<td>${dto.writer}</td>
						<td>${dto.publish}</td>
						<td>${dto.year}</td>
					</tr>
				</c:forEach>
			</table>
			
			<a href="bookAddForm.jsp"><input type="button" value="�����߰�" id="writebtn"></a>

			<table class="tab2">
				<tr>
					<td align="center"><c:if test="${startPage > pageBlock}">
							<a href="bookSearchAdmin.do?page=1&index=${index}&req=${req}">[�Ǿ�����]</a>
							<a href="bookSearchAdmin.do?page=${startPage-5}&index=${index}&req=${req}">[����]</a>
						</c:if> <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
							<a href="bookSearchAdmin.do?page=${i}&index=${index}&req=${req}">${i}</a>
						</c:forEach> <c:if test="${endPage < pageCount}">
							<a href="bookSearchAdmin.do?page=${startPage+5}&index=${index}&req=${req}">[����]</a>
							<a href="bookSearchAdmin.do?page=${pageCount}&index=${index}&req=${req}">[�ǵڷ�]</a>
						</c:if></td>
				</tr>
			</table>
		</div>
	</div>
	</main>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>