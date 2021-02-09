package com.command.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.dao.MemberDao;
import com.dto.MemberDto;

public class PwChangeCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		// 세션에서 아이디값 받아오기
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		String pw = request.getParameter("pw");
		String pw1 = request.getParameter("changePw");
		
		MemberDto dto = new MemberDto();
		MemberDao dao = MemberDao.getInstance();

		int confirmPw = dao.confirmPw(id, pw);
		
		if (confirmPw == 0) {
			int ri = 0;

			request.setAttribute("ri", ri);
			
		} else {
			dto.setId(id);
			dto.setPw(pw1);

			int ri = dao.PwModify(dto);
			
			request.setAttribute("ri", ri);
		}
	}
}
