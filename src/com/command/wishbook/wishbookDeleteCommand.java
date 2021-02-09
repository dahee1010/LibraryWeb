package com.command.wishbook;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.WishbookDao;

public class wishbookDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String wbNum = request.getParameter("wbNum");
		
		WishbookDao dao = new WishbookDao();
		int ri = dao.wishbookDelete(wbNum);
		
		request.setAttribute("ri", ri);
		
	}
}
