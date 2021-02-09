<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/pwcheckalert.css">
</head>
<body>

	<div id="alert">
		<form action="memberPwCheckOk.do" method="post">

			<table>
				<tr>
					<td colspan="2">안전한 정보수정을 위해 비밀번호를 재확인합니다.</td>
				</tr>
				<tr>
					<th width="80px">비 밀 번 호</th>
					<td><input type="password" name="pw" id="pw" size="25"></td>
				</tr>
			</table>

			<input type="submit" value="확인">
		</form>
	</div>

</body>
</html>