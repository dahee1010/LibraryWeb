package com.command.review;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.dao.ReviewDao;

public class ReviewWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();

		int bNum = Integer.parseInt(request.getParameter("bookNum"));
		String rId = (String) session.getAttribute("id");
		String rContent = request.getParameter("rContent");
		int rating = Integer.parseInt(request.getParameter("rating"));

		ReviewDao dao = new ReviewDao();
		int ri = dao.reviewWrite(bNum, rId, rContent, rating);

		request.setAttribute("ri", ri);

	}
}