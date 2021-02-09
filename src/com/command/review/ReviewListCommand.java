package com.command.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.ReviewDao;
import com.dto.ReviewDto;

public class ReviewListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int bNum = Integer.parseInt(request.getParameter("bookNum"));
		
		ReviewDao dao = new ReviewDao();
		ArrayList<ReviewDto> dtos = dao.reviewList(bNum);
		
		request.setAttribute("list", dtos);
		
	}
}
