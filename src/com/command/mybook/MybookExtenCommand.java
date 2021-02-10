package com.command.mybook;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.MybookDao;

public class MybookExtenCommand implements Command {

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int mbNum = Integer.parseInt(request.getParameter("mbNum"));
		
		MybookDao dao = new MybookDao();
		int ri = dao.mybookExten(mbNum);
		
		request.setAttribute("ri", ri);
		
	}

}
