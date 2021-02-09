package com.command.mybook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.MybookDao;
import com.dto.MybookDto;

public class MybookAllCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		MybookDao dao = new MybookDao();

		int pagenum = 1; // 페이지 번호
		if (request.getParameter("page") != null) {
			pagenum = Integer.parseInt(request.getParameter("page"));
		}

		int data = 10; // 보여줄 데이터 크기
		int tot; // 페이지수

		int cnt = dao.mybookCount();

		tot = cnt / data;

		if (cnt % data != 0) {
			tot++;
		}

		int start = ((pagenum - 1) * data) + 1;
		int end = pagenum * data;

		ArrayList<MybookDto> dtos = dao.mybookAll(start, end);

		request.setAttribute("list", dtos);
		request.setAttribute("tot", tot);
		request.setAttribute("data", data);
		request.setAttribute("cnt", cnt);
		request.setAttribute("pagenum", pagenum);

	}
}
