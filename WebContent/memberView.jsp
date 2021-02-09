<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/bookadmin.css">
<script language="javascript">
function win_op(mypage, myname, w, h, scroll) {
var winl = (screen.width - w) / 2;
var wint = (screen.height - h) / 2;
winprops = 'height='+h+',width='+w+',top='+wint+',left='+winl+',scrollbars='+scroll+',resizable'
win = window.open(mypage, myname, winprops)
if (parseInt(navigator.appVersion) >= 4) { win.window.focus(); }
}
</script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| 회원정보 |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="sidemenuMember.jsp" />

		<form action="#" method="post">
			<table>

				<tr>
					<th>아이디</th>
					<td>${view.id}</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${view.name}</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>${fn:substring(view.birth, 0,10)}</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>${view.gender}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${view.eMail}</td>
				</tr>
			</table>

			<input type="button" value="정보수정"  id="writebtn" onclick="win_op('memberPwCheck.jsp', '비밀번호확인', '500', '200')">
		</form>

	</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>