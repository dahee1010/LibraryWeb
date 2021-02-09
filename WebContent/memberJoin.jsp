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
		$(this).val(id); // 아이디 공백제거
		var checkID = /^[a-z-0-9]{4,12}$/;
		
		if(id.length == 0) {
			$("#idInfo").html('필수정보입니다.');
			$("#idInfo").css("color", "red");
			
		} else if(!checkID.test(id)) {
			$("#idInfo").html('4~12자의 영문 소문자와 숫자만 사용 가능합니다.');
			$("#idInfo").css("color", "red");
		}
		else {
			// 서버에 아이디 중복체크하러 ajax 처리
			$("#idInfo").load("idCheck.do?id=" + id);
		}
	});
	
	$("#pw").blur(function(){
		var pw= $('#pw').val();
		var pw_check = $('#pw_check').val();
		
		if(pw.length == 0) {
			$("#pwInfo").html('필수정보입니다.');
			$("#pwInfo").css("color", "red");
		} else if (pw != pw_check) {
			$("#pwcheckInfo").html('비밀번호가 일치하지 않습니다.');
			$("#pwcheckInfo").css("color", "red");
		} else {
			$("#pwInfo").html('');
		}
	});
	
	$("#pw_check").blur(function(){
		var pw= $('#pw').val();
		var pw_check = $('#pw_check').val();
		
		if(pw_check.length == 0) {
			$("#pwcheckInfo").html('필수정보입니다.');
			$("#pwcheckInfo").css("color", "red");
		} else if(pw != pw_check) {
			$("#pwcheckInfo").html('비밀번호가 일치하지 않습니다.');
			$("#pwcheckInfo").css("color", "red");
		} else {
			$("#pwcheckInfo").html('');
		}
	});
	
	$("#name").blur(function(){
		var name= $('#name').val();
		
		if(name.length == 0) {
			$("#nameInfo").html('필수정보입니다.');
			$("#nameInfo").css("color", "red");
		} else {
			$("#nameInfo").html('');
		}
	});
	
	$("#birth").blur(function(){
		var birth= $('#birth').val();
		var checkBirth = /([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))/;
		
		if(birth.length == 0) {
			$("#birthInfo").html('필수정보입니다.');
			$("#birthInfo").css("color", "red");
		} else if(!checkBirth.test(birth)) {
			$("#birthInfo").html('생년월일을 다시 확인해주세요.')
			$("#birthInfo").css("color", "red");
		} else {
			$("#birthInfo").html('');
		}
	});
	
	$("#gender").blur(function(){
		var birth= $('#birth').val();
		var checkBirth = /([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))/;
		
		if(birth.length == 0) {
			$("#birthInfo").html('필수정보입니다.');
			$("#birthInfo").css("color", "red");
		} else if(!checkBirth.test(birth)) {
			$("#birthInfo").html('생년월일을 다시 확인해주세요.')
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

			<!-- 회원가입 -->
			<form action="join.do" method="post" name="reg_frm">
				<!-- <a class="rqtext">*은 필수사항입니다.</a>-->
				<input type="text" class="fadeIn first" name="id" id="id" placeholder="* 아이디" style="ime-mode:inactive" required>
				<div id = "idInfo"></div>
				
				<input type="password" class="fadeIn first" name="pw" id="pw" placeholder="* 비밀번호" required>
				<div id = "pwInfo"></div>
				<input type="password" class="fadeIn first" name="pw_check" id="pw_check" placeholder="* 비밀번호 확인" required>
				<div id = "pwcheckInfo"></div>
				
				<input type="text" class="fadeIn second" name="name" id="name" placeholder="* 이름" required>
				<div id = "nameInfo"></div>
								
				<input type="text" class="fadeIn second" name="birth" id="birth" placeholder="*생년월일 (YYMMDD)" style="ime-mode:inactive" required>
				<div id = "birthInfo"></div>
				
				<div class="fadeIn radiobtn">
					<label class="box-radio-input"> <input type="radio" name="gender" value="man"> <span>남성</span> </label>
					<label class="box-radio-input"> <input type="radio" name="gender" value="woman"> <span>여성</span> </label>
				</div>

				<input type="text" class="fadeIn third" name="eMail" placeholder="이메일 (선택)" pattern="^[a-zA-Z0-9]+@[a-zA-Z0-9]+$">
				
				<input type="button" class="fadeIn fourth" value="Sign up" onclick="infoConfirm()">
			</form>


			<div id="formFooter">
				<a class="underlineHover" href="memberLogin.jsp">이미 회원이에요 >로그인하기</a>
			</div>

		</div>
	</div>
</body>
</html>