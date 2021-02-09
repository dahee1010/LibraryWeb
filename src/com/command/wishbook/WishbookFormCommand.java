package com.command.wishbook;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.WishbookDao;

public class WishbookFormCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		String wbName = request.getParameter("wbName");
		String wbWriter = request.getParameter("wbWriter");
		String wbPublish = request.getParameter("wbPublish");
		int wbYear = Integer.parseInt(request.getParameter("wbYear"));

		WishbookDao dao = new WishbookDao();
		int ri = dao.wishbookAdd(wbName, wbWriter, wbPublish, wbYear);

		request.setAttribute("ri", ri);
	}
}
