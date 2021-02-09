package com.command.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.BookDao;
import com.dto.BookDto;

public class BookRandomListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		BookDao dao = new BookDao();
		ArrayList<BookDto> dtos = dao.radomBook();
		
		request.setAttribute("randombook", dtos);
	}
}
