package com.command.que;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.QueDao;
import com.dto.QueDto;

public class QueViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		int qNum = Integer.parseInt(request.getParameter("qNum"));

		QueDao dao = new QueDao();
		QueDto dto = dao.contentView(qNum);

		request.setAttribute("view", dto);

	}
}
