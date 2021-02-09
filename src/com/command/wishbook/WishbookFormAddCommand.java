package com.command.wishbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.WishbookDao;
import com.dto.WishbookDto;

public class WishbookFormAddCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int wbNum = Integer.parseInt(request.getParameter("wbNum"));
		
		WishbookDao dao = new WishbookDao();
		ArrayList<WishbookDto> dtos = dao.wishbook(wbNum);
		
		request.setAttribute("list", dtos);		
		
	}

}
