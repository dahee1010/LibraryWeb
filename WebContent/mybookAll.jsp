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
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 대출도서관리 |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="sidemenu.jsp" />

		<div id="content">
		<span>* 반납일자가 초과된 항목은 자동으로 삭제됩니다.</span>
		
			<table class="tab1" style="margin-top:130px">
				<tr>
					<th>No.</th>
					<th>아이디</th>
					<th width="300px">도서명</th>
					<th>저자명</th>
					<th width="100px">대출일자</th>
					<th width="100px">반납일자</th>
				</tr>

				<c:forEach items="${list}" var="dto" varStatus="status">
					<tr>
						<td>${cnt - ((pagenum-1) * data + status.index)}</td>
						<td>${dto.mbId}</td>
						<td>${dto.mbName}</td>
						<td>${dto.mbWriter}</td>
						<td>${fn:substring(dto.mbDate, 0,10)}</td>
						<td>${fn:substring(dto.mbRdate, 0,10)}</td>
					</tr>
				</c:forEach>
			</table>

			<table class="tab2">
				<tr>
					<td align="center"><c:forEach var="i" begin="1" end="${tot}">
							<a href="mybookAll.do?page=${i}">${i}</a>
						</c:forEach></td>
				</tr>

			</table>
		</div>
	</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>