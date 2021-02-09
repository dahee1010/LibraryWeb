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
		<a>| 희망도서신청 |</a>
	</div>

	<main>

	<section>
		<form action="wishbookForm.do" method="post">

			<a>해당 폼을 작성해주세요.</a> <br> <br> <br> <br>
			
			<label>도서명</label>
			<input type="text" name="wbName" required> <br />
			
			<label>저자명 </label>
			<input type="text" name="wbWriter" required> <br />
			
			<label>출판사 </label>
			<input type="text" name="wbPublish" required> <br />
			
			<label>발행년 </label>
			<input type="text" name="wbYear" required pattern="^(18|19|20)\d{2}$" title="형식: 숫자로 된 연도 4자리"> <br />
			
			<input type="submit" value="제출하기">
		</form>
	</section>

	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>