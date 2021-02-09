package com.command.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.MemberDao;

public class MemberDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub\
		
		String id = request.getParameter("id");
		
		MemberDao dao = MemberDao.getInstance();
		int ri = dao.DeleteMember(id);

		request.setAttribute("ri", ri);
		request.setAttribute("id", id);
		
		System.out.println(ri);
		System.out.println(id);
	}

}
