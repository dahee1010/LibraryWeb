package com.command.review;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.ReviewDao;

public class ReviewDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		int rNum = Integer.parseInt(request.getParameter("rNum"));

		ReviewDao dao = new ReviewDao();
		int ri = dao.reviewDelete(rNum);

		request.setAttribute("ri", ri);

	}
}
