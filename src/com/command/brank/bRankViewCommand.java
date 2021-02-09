package com.command.brank;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.bRankDao;
import com.dto.bRankDto;

public class bRankViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		bRankDao dao = new bRankDao();
		ArrayList<bRankDto> dtos = dao.bookRank();
		
		request.setAttribute("bookrank", dtos);
		
	}
}
