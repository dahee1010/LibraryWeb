package com.command.wishbook;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.BookDao;
import com.dao.WishbookDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WishbookAddCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		MultipartRequest multi = null;

		int sizeLimit = 1024 * 1024 * 15;
		String savePath = request.getServletContext().getRealPath("bookimg");
		String path = "bookimg";
		
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit, "euc-kr", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//도서추가부분
		String bookName = multi.getParameter("wbName");
		String writer = multi.getParameter("wbWriter");
		String publish = multi.getParameter("wbPublish");
		int year = Integer.parseInt(multi.getParameter("wbYear"));
		String code = multi.getParameter("code");
		int bCnt = Integer.parseInt(multi.getParameter("bCnt"));
		int cnt = 0;
		String file = multi.getFilesystemName("file");
		
		if (file != null) { //파일이 널이 아닐때만 path에 파일이름 추가 후 전송
			
			String bookimg = path + "/" + file;

			BookDao dao = new BookDao();
			int ri = dao.bookAdd(bookName, writer, publish, year, code, bCnt, cnt, bookimg);

			request.setAttribute("ri", ri);
			
		} else { // 파일이 null 일때는 쓰레기값(path+파일명) 들어가지 않게 한다 그렇지 않으면 이상한 값 들어감
			String bookimg = null;
			
			BookDao dao = new BookDao();
			int ri = dao.bookAdd(bookName, writer, publish, year, code, bCnt, cnt, bookimg);

			request.setAttribute("ri", ri);
		}
		
		//희망도서삭제부분
		String wbNum = multi.getParameter("wbNum");
		
		WishbookDao dao1 = new WishbookDao();
		dao1.wishbookDelete(wbNum);

	}
}
