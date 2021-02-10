package com.command.que;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.QueDao;

public class QueModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		int qNum = Integer.parseInt(request.getParameter("qNum"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String open = request.getParameter("open");

		content = content.replace("\r\n","<br>");
		
		QueDao dao = new QueDao();
		int ri = dao.queModify(qNum, title, content, open);

		request.setAttribute("qNum", qNum);
		request.setAttribute("ri", ri);

	}
}
