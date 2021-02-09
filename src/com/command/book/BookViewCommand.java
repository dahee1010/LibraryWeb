package com.command.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.BookDao;
import com.dao.ReviewDao;
import com.dto.BookDto;
import com.dto.ReviewDto;

public class BookViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		// 책 상세정보 보여주기
		int bookNum = Integer.parseInt(request.getParameter("bookNum"));
		
		BookDao dao = new BookDao();
		BookDto dto = dao.contentView(bookNum);

		request.setAttribute("view", dto);
		
		// 해당 책에 있는 리뷰 보여주기
		ReviewDao review = new ReviewDao();
		ArrayList<ReviewDto> dtos = review.reviewList(bookNum);

		request.setAttribute("review", dtos);

	}
}
