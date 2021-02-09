package com.command.ans;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.AnsDao;

public class AnsModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int qNum = Integer.parseInt(request.getParameter("qNum"));
		String content = request.getParameter("content");

		AnsDao dao = new AnsDao();
		int ri = dao.ansModify(qNum, content);

		request.setAttribute("ri", ri);
		request.setAttribute("qNum", qNum);
	}

}
