<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/wishbookform.css">
<script language="JavaScript" src="check.js" charset="utf-8"></script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| ���������û |</a>
	</div>

	<main>

	<section>
		<form action="wishbookForm.do" method="post">

			<a>�ش� ���� �ۼ����ּ���.</a> <br> <br> <br> <br>
			
			<label>������</label>
			<input type="text" name="wbName" required> <br />
			
			<label>���ڸ� </label>
			<input type="text" name="wbWriter" required> <br />
			
			<label>���ǻ� </label>
			<input type="text" name="wbPublish" required> <br />
			
			<label>����� </label>
			<input type="text" name="wbYear" required pattern="^(18|19|20)\d{2}$" title="����: ���ڷ� �� ���� 4�ڸ�"> <br />
			
			<input type="submit" value="�����ϱ�">
		</form>
	</section>

	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>