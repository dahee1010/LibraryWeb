package com.command.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.BoardDao;

public class BoardDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		int wNum = Integer.parseInt(request.getParameter("wNum"));

		BoardDao dao = new BoardDao();

		int ri = dao.boardDelete(wNum);

		request.setAttribute("ri", ri);
	}

}
