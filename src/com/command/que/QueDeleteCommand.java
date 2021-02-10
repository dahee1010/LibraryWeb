package com.command.que;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.AnsDao;
import com.dao.QueDao;

public class QueDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int qNum = Integer.parseInt(request.getParameter("qNum"));
		
		//질문글 삭제
		QueDao dao = new QueDao();
		int ri = dao.queDelete(qNum);
		
		request.setAttribute("ri", ri);
		
		//답변글 삭제
		AnsDao ans = new AnsDao();
		ans.ansDelete(qNum);
	}
}
