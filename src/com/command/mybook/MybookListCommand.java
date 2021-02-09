package com.command.mybook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.dao.MybookDao;
import com.dto.MybookDto;

public class MybookListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String mbId = (String) session.getAttribute("id");

		MybookDao dao = new MybookDao();
		ArrayList<MybookDto> dtos = dao.mybookList(mbId);

		request.setAttribute("mbId", mbId);
		request.setAttribute("list", dtos);

	}
}
