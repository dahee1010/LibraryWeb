package com.command.member;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.MemberDao;
import com.dto.MemberDto;

public class JoinCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String eMail = request.getParameter("eMail");

		MemberDto dto = new MemberDto();
		MemberDao dao = MemberDao.getInstance();

		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setGender(gender);
		dto.seteMail(eMail);
		dto.setrDate(new Timestamp(System.currentTimeMillis()));

		int confirmId = dao.confirmId(id);
		int ri = dao.insertMember(dto);

		request.setAttribute("ri", ri);
		request.setAttribute("confirmId", confirmId);

	}

}
