<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/join.css">
<link rel="stylesheet" href="css/radio.css">
<script language="JavaScript" src="members.js" charset="utf-8"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function() {
	
	$("#id").blur(function(){
		var id = $.trim($(this).val());
		$(this).val(id); // ���̵� ��������
		var checkID = /^[a-z-0-9]{4,12}$/;
		
		if(id.length == 0) {
			$("#idInfo").html('�ʼ������Դϴ�.');
			$("#idInfo").css("color", "red");
			
		} else if(!checkID.test(id)) {
			$("#idInfo").html('4~12���� ���� �ҹ��ڿ� ���ڸ� ��� �����մϴ�.');
			$("#idInfo").css("color", "red");
		}
		else {
			// ������ ���̵� �ߺ�üũ�Ϸ� ajax ó��
			$("#idInfo").load("idCheck.do?id=" + id);
		}
	});
	
	$("#pw").blur(function(){
		var pw= $('#pw').val();
		var pw_check = $('#pw_check').val();
		
		if(pw.length == 0) {
			$("#pwInfo").html('�ʼ������Դϴ�.');
			$("#pwInfo").css("color", "red");
		} else if (pw != pw_check) {
			$("#pwcheckInfo").html('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');
			$("#pwcheckInfo").css("color", "red");
		} else {
			$("#pwInfo").html('');
		}
	});
	
	$("#pw_check").blur(function(){
		var pw= $('#pw').val();
		var pw_check = $('#pw_check').val();
		
		if(pw_check.length == 0) {
			$("#pwcheckInfo").html('�ʼ������Դϴ�.');
			$("#pwcheckInfo").css("color", "red");
		} else if(pw != pw_check) {
			$("#pwcheckInfo").html('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');
			$("#pwcheckInfo").css("color", "red");
		} else {
			$("#pwcheckInfo").html('');
		}
	});
	
	$("#name").blur(function(){
		var name= $('#name').val();
		
		if(name.length == 0) {
			$("#nameInfo").html('�ʼ������Դϴ�.');
			$("#nameInfo").css("color", "red");
		} else {
			$("#nameInfo").html('');
		}
	});
	
	$("#birth").blur(function(){
		var birth= $('#birth').val();
		var checkBirth = /([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))/;
		
		if(birth.length == 0) {
			$("#birthInfo").html('�ʼ������Դϴ�.');
			$("#birthInfo").css("color", "red");
		} else if(!checkBirth.test(birth)) {
			$("#birthInfo").html('��������� �ٽ� Ȯ�����ּ���.')
			$("#birthInfo").css("color", "red");
		} else {
			$("#birthInfo").html('');
		}
	});
	
	$("#gender").blur(function(){
		var birth= $('#birth').val();
		var checkBirth = /([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))/;
		
		if(birth.length == 0) {
			$("#birthInfo").html('�ʼ������Դϴ�.');
			$("#birthInfo").css("color", "red");
		} else if(!checkBirth.test(birth)) {
			$("#birthInfo").html('��������� �ٽ� Ȯ�����ּ���.')
			$("#birthInfo").css("color", "red");
		} else {
			$("#birthInfo").html('');
		}
	});
});
</script>
</head>
<body>

	<div class="wrapper fadeInDown">

		<div id="formContent">

			<a href="memberLogin.jsp">
			<h2 class="inactive underlineHover">Login</h2></a>
			<h2 class="active">Sign Up</h2>

			<!-- ȸ������ -->
			<form action="join.do" method="post" name="reg_frm">
				<!-- <a class="rqtext">*�� �ʼ������Դϴ�.</a>-->
				<input type="text" class="fadeIn first" name="id" id="id" placeholder="* ���̵�" style="ime-mode:inactive" required>
				<div id = "idInfo"></div>
				
				<input type="password" class="fadeIn first" name="pw" id="pw" placeholder="* ��й�ȣ" required>
				<div id = "pwInfo"></div>
				<input type="password" class="fadeIn first" name="pw_check" id="pw_check" placeholder="* ��й�ȣ Ȯ��" required>
				<div id = "pwcheckInfo"></div>
				
				<input type="text" class="fadeIn second" name="name" id="name" placeholder="* �̸�" required>
				<div id = "nameInfo"></div>
								
				<input type="text" class="fadeIn second" name="birth" id="birth" placeholder="*������� (YYMMDD)" style="ime-mode:inactive" required>
				<div id = "birthInfo"></div>
				
				<div class="fadeIn radiobtn">
					<label class="box-radio-input"> <input type="radio" name="gender" value="man"> <span>����</span> </label>
					<label class="box-radio-input"> <input type="radio" name="gender" value="woman"> <span>����</span> </label>
				</div>

				<input type="text" class="fadeIn third" name="eMail" placeholder="�̸��� (����)" pattern="^[a-zA-Z0-9]+@[a-zA-Z0-9]+$">
				
				<input type="button" class="fadeIn fourth" value="Sign up" onclick="infoConfirm()">
			</form>


			<div id="formFooter">
				<a class="underlineHover" href="memberLogin.jsp">�̹� ȸ���̿��� >�α����ϱ�</a>
			</div>

		</div>
	</div>
</body>
</html>