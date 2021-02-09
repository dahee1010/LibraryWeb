package com.command.mybook;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.BookDao;
import com.dao.MybookDao;

public class MybookDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String mbNum = request.getParameter("mbNum");
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		
		MybookDao dao = new MybookDao();
		int ri = dao.mybookDelete(mbNum);
		
		request.setAttribute("ri", ri);
		
		// 책 반납시 대출횟수 -1 해주기
		BookDao book = new BookDao();
		book.returnBook(bNum);
		
	}
}
