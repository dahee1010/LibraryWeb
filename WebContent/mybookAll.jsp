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
		<a>| ���⵵������ |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="sidemenu.jsp" />

		<div id="content">
		<span>* �ݳ����ڰ� �ʰ��� �׸��� �ڵ����� �����˴ϴ�.</span>
		
			<table class="tab1" style="margin-top:130px">
				<tr>
					<th>No.</th>
					<th>���̵�</th>
					<th width="300px">������</th>
					<th>���ڸ�</th>
					<th width="100px">��������</th>
					<th width="100px">�ݳ�����</th>
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