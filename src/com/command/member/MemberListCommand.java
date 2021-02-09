package com.command.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.MemberDao;
import com.dto.MemberDto;

public class MemberListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		MemberDao dao = MemberDao.getInstance();

		int pagenum = 1; // 페이지 번호
		if (request.getParameter("memberPage") != null) {
			pagenum = Integer.parseInt(request.getParameter("memberPage"));
		}

		int data = 10; // 보여줄 데이터 크기
		int tot; // 페이지수

		int cnt = dao.memberCount();

		tot = cnt / data;

		if (cnt % data != 0) {
			tot++;
		}

		int start = ((pagenum - 1) * data) + 1;
		int end = pagenum * data;

		ArrayList<MemberDto> dtos = dao.memberList(start, end);

		request.setAttribute("list", dtos);
		request.setAttribute("tot", tot);

	}
}
