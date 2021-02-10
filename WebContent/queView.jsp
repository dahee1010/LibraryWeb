<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/qnaview.css">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| Q&A |</a>
	</div>

	<main>
	
	<form action="queModify.do" method="post">
		<input type="hidden" name="qNum" value="${view.qNum}">

		<table>
			<tr>
				<th colspan=6 id="title">Q. ${view.title}</th>
			</tr>

			<tr>
				<th>�ۼ���</th>
				<td>${view.qId}</td>
				<th>�����</th>
				<td>${fn:substring(view.qDate, 0,16)}</td>
			</tr>
			<tr>
				<td colspan=6 id="content">${view.content}</td>
			</tr>
		</table>
		<c:if test="${id eq view.qId and empty ans.aNum}">
			<a href="queDelete.do?qNum=${view.qNum}"><input type="button" value="����" id="deletebtn" /></a>
			<input type="submit" value="����" id="modifybtn">
			<a href="queList.do"><input type="button" value="���" id="cancelbtn" /></a>
		</c:if>
		
		<c:if test="${id eq view.qId and not empty ans.aNum}">
			<a href="queDelete.do?qNum=${view.qNum}"><input type="button" value="����" id="deletebtn1" /></a>
			<input type="submit" value="����" id="modifybtn1">
		</c:if>
		
		<c:if test="${id eq 'admin' and empty ans.aNum}">
			<a href="ansWrite.do?qNum=${view.qNum}"><input type="button" value="�亯" id="replybtn" /></a>
			<a href="queList.do"><input type="button" value="���" id="cancelbtn" /></a>
		</c:if>
		
		<c:if test="${id ne 'admin' and empty ans.aNum}">
			<a href="queList.do"><input type="button" value="���" id="cancelbtn" /></a>
		</c:if>

	</form>
	
	
	
	
	<c:if test="${not empty ans.aNum}">
	
	<form action="ansModify.do" method="post">
		<input type="hidden" name="qNum" value="${view.qNum}">

		<table style="margin-top: 100px">
			<tr>
				<th colspan=6 id="title">A. ${ans.qTitle}
				<span>${fn:substring(ans.aDate, 0,16)}</span></th>
			</tr>
			<tr>
				<td colspan=6 id="content">${ans.content}</td>
			</tr>
		</table>

		<c:if test="${id eq 'admin'}">
			<a href="ansDelete.do?qNum=${view.qNum}"><input type="button" value="����" id="deletebtn" /></a>
			<input type="submit" value="����" id="modifybtn">
			<a href="queList.do"><input type="button" value="���" id="cancelbtn" /></a>
		</c:if>
		
		<c:if test="${id ne 'admin'}">
			<a href="queList.do"><input type="button" value="���" id="cancelbtn" /></a>
		</c:if>

	</form>
	
	</c:if>
	
	
	
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>