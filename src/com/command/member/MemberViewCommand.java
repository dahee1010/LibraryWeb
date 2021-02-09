package com.command.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.dao.MemberDao;
import com.dto.MemberDto;

public class MemberViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		// 세션에서 아이디값 받아오기
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");

		MemberDao dao = MemberDao.getInstance();
		MemberDto dtos = dao.memberView(id);

		request.setAttribute("view", dtos);
		
	}
}
