package com.command.book;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.BookDao;

public class BookDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int bookNum = Integer.parseInt(request.getParameter("bookNum"));
		
		BookDao dao = new BookDao();
		int ri = dao.bookDelete(bookNum);
		
		request.setAttribute("ri", ri);
		
	}

}
