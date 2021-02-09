package com.command.mrank;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.mRankDao;
import com.dto.mRankDto;

public class mRankViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		mRankDao dao = new mRankDao();
		ArrayList<mRankDto> dtos = dao.memberRank();
		
		request.setAttribute("memberrank", dtos);
		
	}
}
