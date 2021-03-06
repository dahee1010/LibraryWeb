package com.command.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.BoardDao;
import com.dto.BoardDto;

public class BoardListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int pagenum;

		BoardDao dao = new BoardDao();

		if (request.getParameter("page") != null) { // 페이지 번호가 있다면 원래 검색내역이 존재한다는 것이므로 url에서 정보 빼오기
			pagenum = Integer.parseInt(request.getParameter("page"));
		} else { // 없다면 입력값 받아오기
			pagenum = 1; // 페이지 번호
		}

		int data = 10; // 보여줄 데이터 크기
		int tot; // 페이지수

		int cnt = dao.boardCount();

		tot = cnt / data; // 총 페이지 수
		
		int block = 10; // 한 페이지에 보여줄 블록수

		if (cnt % data != 0) {
			tot++;
		}

		// 해당페이지의 시작 레코드와 마지막 레코드
		int start = ((pagenum - 1) * data) + 1; 
		int end = pagenum * data;

		ArrayList<BoardDto> dtos = dao.boardList(start, end);
		
		// 페이지 블록
		int startPage = ((pagenum - 1)/ block ) * block + 1; 
		int endPage = startPage + block - 1;
		
		if(endPage > tot){
			endPage = tot;
		}

		request.setAttribute("boardlist", dtos);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageBlock", block);
		request.setAttribute("pageCount", tot);
		request.setAttribute("cnt", cnt);
		request.setAttribute("pagenum", pagenum);
		
	}
}
