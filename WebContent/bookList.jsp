<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/search.css">
<link rel="stylesheet" href="css/booklist.css">
<script language="JavaScript" src="check.js" charset="utf-8"></script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| �����˻� |</a>
	</div>

	<main>

	<div class="searchform">
		<form action="bookSearch.do" method="post" name="search_frm">
			<select name="how">
				<option value="����">����</option>
				<option value="����">����</option>
				<option value="���ǻ�">���ǻ�</option>
			</select> <input type="text" size="20" name="obj" placeholder="�˻�� �Է����ּ���.">
			<input type="button" value="�˻�" onclick="searchConfirm()">
		</form>
	</div>

	<br>

	<c:choose>

		<c:when test="${empty list}">
			<p
				style="border: 1px solid gray; width: 800px; padding: 10px; font: 13px KoPubWorld����ü Medium; font-size: 18px;">
				���������� �����ϰ� �ִ� ������ �ڷḦ ���� �˻� �� �� �ֽ��ϴ�. <br> �˻��� ����, ���ں�, ���ǻ纰��
				�˻� �� �� �ֽ��ϴ�.
			</p>
		</c:when>



		<c:otherwise>
			<table class="tab1">

				<c:forEach items="${list}" var="dto">

					<tr>
						<td><a href="bookView.do?bookNum=${dto.bookNum}">${dto.bookName}<br>
								���� : ${dto.writer} | ���ǻ� : ${dto.publish} | ����⵵ : ${dto.year}
						</a></td>
					</tr>

				</c:forEach>

			</table>

			<table class="tab2">
				<tr>
					<td align="center">
					<c:if test="${startPage > pageBlock}">
							<a href="bookList.do?page=1">[�Ǿ�����]</a>
							<a href="bookList.do?page=${startPage-10}">[����]</a>
						</c:if>
						
						<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
							<a href="bookList.do?page=${i}">${i}</a>
						</c:forEach>
						
						<c:if test="${endPage < pageCount}">
							<a href="bookList.do?page=${startPage+10}">[����]</a>
							<a href="bookList.do?page=${pageCount}">[�ǵڷ�]</a>
						</c:if>
					</td>
				</tr>
			</table>
		</c:otherwise>

	</c:choose> </main>


	<jsp:include page="footer.jsp" />

</body>
</html>