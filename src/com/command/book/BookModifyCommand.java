package com.command.book;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.dao.BookDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BookModifyCommand implements Command {

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

		int bookNum = Integer.parseInt(multi.getParameter("bookNum"));
		String bookName = multi.getParameter("bookName");
		String writer = multi.getParameter("writer");
		String publish = multi.getParameter("publish");
		int year = Integer.parseInt(multi.getParameter("year"));
		String code = multi.getParameter("code");
		int bCnt = Integer.parseInt(multi.getParameter("bCnt"));
		String file1 = multi.getParameter("bookimg1");
		String file2 = multi.getFilesystemName("bookimg2");
		
		if (file2 != null) { // 이미지 업데이트 시, 즉 파일이 널이 아닐 때는 path에 파일이름 추가 후 전송

			String bookimg = path + "/" + file2;

			BookDao dao = new BookDao();
			int ri = dao.bookModify(bookNum, bookName, writer, publish, year, code, bCnt, bookimg);

			request.setAttribute("ri", ri);

		} else if (file2 == null && file1 != null) { // 이미지가 업데이트 되지는 않았지만 원래 파일값이 있을 경우

			String bookimg = file1;

			BookDao dao = new BookDao();
			int ri = dao.bookModify(bookNum, bookName, writer, publish, year, code, bCnt, bookimg);

			request.setAttribute("ri", ri);
			
		} else { // 이미지 업데이트도 되지 않았고, 원래 파일값도 없을 경우
			
			String bookimg = null;

			BookDao dao = new BookDao();
			int ri = dao.bookModify(bookNum, bookName, writer, publish, year, code, bCnt, bookimg);

			request.setAttribute("ri", ri);

		}
	}
}
