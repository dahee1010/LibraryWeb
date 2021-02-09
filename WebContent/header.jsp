<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/hearderfooter.css">
</head>
<body>

	<header>
		<div id="header1">

			<div id="logo">
				<a href="main.do"><img src="css/logo.png" alt="��������" width="65%"></a>
			</div>

			<div id="top_menu">
				<!-- ù��° �޴� -->
				<c:if test="${id eq 'admin'}">
					<a href="memberList.do">${id}�� �ȳ��ϼ���.</a>
				</c:if>

				<c:if test="${id ne 'admin'}">
					<a href="memberView.do">${id}�� �ȳ��ϼ���.</a>
				</c:if>
			��|��<a href="mybookList.do">������</a>��|��<a href="memberLogout.jsp">�α׾ƿ�</a>
			</div>
		</div>

		<nav>
			<!-- �ι�° �޴� -->
			<ul>
				<li><a href="bookList.jsp">�����˻���</a></li>
				<li><a href="wishbookForm.jsp">���������û��</a></li>
				<li><a href="boardList.do">�������ס�</a></li>
				<li><a href="queList.do">Q&A��</a></li>
			</ul>
		</nav>

	</header>

</body>
</html>