<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/detailmenu.css">
<link rel="stylesheet" href="css/bookadmin.css">
<script language="JavaScript" src="check.js" charset="utf-8"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("#changePw").blur(function() {
			var changePw = $('#changePw').val();
			var changePw_check = $('#changePw_check').val();

			if (changePw.length == 0) {
				$("#changePwInfo1").html('�ʼ������Դϴ�.');
				$("#changePwInfo1").css("color", "red");
			} else if (changePw != changePw_check) {
				$("#changePwInfo2").html('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');
				$("#changePwInfo2").css("color", "red");
				$('#writebtn').attr('disabled', true);
			} else {
				$("#changePwInfo1").html('');
				$('#writebtn').attr('disabled', false);
			}
		});

		$("#changePw_check").keyup(function() {
			var changePw = $('#changePw').val();
			var changePw_check = $('#changePw_check').val();

			if (changePw_check.length == 0) {
				$("#changePwInfo2").html('�ʼ������Դϴ�.');
				$("#changePwInfo2").css("color", "red");
			} else if (changePw != changePw_check) {
				$("#changePwInfo2").html('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');
				$("#changePwInfo2").css("color", "red");
				$('#writebtn').attr('disabled', true);
			} else {
				$("#changePwInfo2").html('');
				$('#writebtn').attr('disabled', false);
			}
		});
	});
</script>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="detailmenu">
		<a>| ��й�ȣ���� |</a>
	</div>

	<main>

	<div id="admin">
		<jsp:include page="sidemenuMember.jsp" />

		<form action="memberPwChangeOk.do" method="post">

			<table>
				<tr>
					<th>���� ��й�ȣ</th>
					<td><input type="password" name="pw" id="pw" required>
					<br><div id = "pwInfo"></div>
					</td>
				</tr>
				<tr>
					<th>�� ��й�ȣ</th>
					<td><input type="password" name="changePw" id="changePw" required>
					<br><div id = "chagePwInfo1"></div>
					</td>
				</tr>
				<tr>
					<th>�� ��й�ȣ Ȯ��</th>
					<td><input type="password" name="changePw_check" id="changePw_check" required>
					<br><div id = "changePwInfo2"></div>
					</td>
				</tr>
			</table>

			<input type="submit" value="Ȯ��" id="writebtn">
		</form>
	</div>
	</main>

	<jsp:include page="footer.jsp" />

</body>
</html>