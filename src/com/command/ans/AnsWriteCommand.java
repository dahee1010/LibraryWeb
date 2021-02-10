package com.command.ans;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.AnsDao;
import com.dao.QueDao;

public class AnsWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int qNum = Integer.parseInt(request.getParameter("qNum"));
		String qtitle = request.getParameter("qtitle");
		String content = request.getParameter("content");
		Timestamp aDate = new Timestamp(System.currentTimeMillis());
		
		content = content.replace("\r\n","<br>");
		
		AnsDao dao = new AnsDao();
		int ri = dao.ansWrite(qNum, qtitle, content, aDate);
		
		request.setAttribute("ri", ri);
		request.setAttribute("qNum", qNum);
		
		// 답변 카운트 올리기
		QueDao upCnt = new QueDao();
		upCnt.upCnt(qNum);
		
	}
}
