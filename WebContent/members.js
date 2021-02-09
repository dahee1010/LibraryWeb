function infoConfirm() {

	var form = document.reg_frm;
	
	var checkID = /^[a-zA-Z0-9]{4,12}$/;
	var checkBirth = /([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))/;

	if (form.id.value.length == 0) {
		alert("아이디는 필수정보입니다.");
		reg_frm.id.focus();
		return false;
	}

	if (!checkID.test(form.id.value)) {
		alert("아이디는 4~12자의 영문 소문자와 숫자만 사용 가능합니다.");
		reg_frm.id.focus();
		return false;
	}

	if (form.pw.value.length == 0) {
		alert("비밀번호는 필수정보입니다.");
		reg_frm.pw.focus();
		return false;
	}

	if (form.pw_check.value.length == 0) {
		alert("비밀번호 확인은 필수정보입니다.");
		reg_frm.pw_check.focus();
		return false;
	}

	if (form.pw.value != form.pw_check.value) {
		alert("비밀번호가 일치하지 않습니다.");
		reg_frm.pw.focus();
		return false;
	}

	if (form.name.value.length == 0) {
		alert("이름은 필수정보입니다.");
		reg_frm.name.focus();
		return false;
	}
	
	if (form.birth.value.length == 0) {
		alert("생년월일은 필수정보입니다.");
		reg_frm.birth.focus();
		return false;
	}

	if 	(!checkBirth.test(form.birth.value)) {
		alert("생년월일은 YYMMDD형식으로 입력가능합니다.");
		reg_frm.birth.focus();
		return false;
	}
	
	document.reg_frm.submit();
}