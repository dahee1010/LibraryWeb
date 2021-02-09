package com.command.board;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.BoardDao;

public class BoardWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String wId = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Timestamp wDate = new Timestamp(System.currentTimeMillis());

		BoardDao dao = new BoardDao();
		int ri = dao.boardWrite(wId, title, content, wDate);

		request.setAttribute("ri", ri);
	}

}
