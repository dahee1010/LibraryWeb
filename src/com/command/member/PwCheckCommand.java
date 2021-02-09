package com.command.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.dao.MemberDao;

public class PwCheckCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");
		String pw = request.getParameter("pw");

		MemberDao dao = MemberDao.getInstance();

		int ri = dao.confirmPw(id, pw);

		request.setAttribute("ri", ri);
		
	}
}
