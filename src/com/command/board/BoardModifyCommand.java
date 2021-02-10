package com.command.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.BoardDao;

public class BoardModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int wNum = Integer.parseInt(request.getParameter("wNum"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		content = content.replace("\r\n","<br>");

		BoardDao dao = new BoardDao();
		int ri = dao.boardModify(wNum, title, content);

		request.setAttribute("ri", ri);
	}
}
