package com.command.ans;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.AnsDao;
import com.dto.AnsDto;

public class AnsViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int qNum = Integer.parseInt(request.getParameter("qNum"));

		AnsDao dao = new AnsDao();
		AnsDto dto = dao.contentView(qNum);

		request.setAttribute("ans", dto);
	}

}
