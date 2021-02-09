package com.command.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.MemberDao;
import com.dto.MemberDto;

public class MemberSearchCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int index = 0;
		
		String req = null;
		String how = null;

		MemberDao dao = MemberDao.getInstance();
		req = (String) request.getParameter("obj");
		how = (String) request.getParameter("how");
		
		if (how.equals("아이디")) {
			index = 0;
		} else 
			index = 1;
		
		ArrayList<MemberDto> search =  dao.findInfo(req, index);
		
		request.setAttribute("search", search);
	}

}
