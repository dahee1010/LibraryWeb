// 도서검색 유효성 검사
function searchConfirm() {

	var form = document.search_frm;

	if (form.obj.value.length == 0) {
		alert("검색어를 입력해주세요.");
		search_frm.obj.focus();
		return false;
	}
	document.search_frm.submit();
}

