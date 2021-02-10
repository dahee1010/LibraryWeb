package com.command.que;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.QueDao;

public class QueWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		String qId = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Timestamp qDate = new Timestamp(System.currentTimeMillis());
		String open = request.getParameter("open");

		content = content.replace("\r\n","<br>");
		
		QueDao dao = new QueDao();
		int ri = dao.queWrite(qId, title, content, qDate, open);

		request.setAttribute("ri", ri);
	}
}
