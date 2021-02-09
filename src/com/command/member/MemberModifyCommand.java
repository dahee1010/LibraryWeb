package com.command.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.dao.MemberDao;
import com.dto.MemberDto;

public class MemberModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		// 세션에서 아이디값 받아오기
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String eMail = request.getParameter("eMail");
		
		MemberDto dto = new MemberDto();
		MemberDao dao = MemberDao.getInstance();
		
		dto.setId(id);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setGender(gender);
		dto.seteMail(eMail);
		
		int ri = dao.MemberModify(dto);
		
		request.setAttribute("ri", ri);
		
	}
}
