package com.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.command.ans.AnsDeleteCommand;
import com.command.ans.AnsModifyCommand;
import com.command.ans.AnsViewCommand;
import com.command.ans.AnsWriteCommand;
import com.command.board.BoardDeleteCommand;
import com.command.board.BoardListCommand;
import com.command.board.BoardModifyCommand;
import com.command.board.BoardViewCommand;
import com.command.board.BoardWriteCommand;
import com.command.book.BookAddCommand;
import com.command.book.BookDeleteCommand;
import com.command.book.BookListCommand;
import com.command.book.BookModifyCommand;
import com.command.book.BookRandomListCommand;
import com.command.book.BookSearchCommand;
import com.command.book.BookViewCommand;
import com.command.brank.bRankViewCommand;
import com.command.member.IdCheckCommand;
import com.command.member.JoinCommand;
import com.command.member.LoginCommand;
import com.command.member.MemberDeleteCommand;
import com.command.member.MemberListCommand;
import com.command.member.MemberModifyCommand;
import com.command.member.MemberSearchCommand;
import com.command.member.MemberViewCommand;
import com.command.member.PwCheckCommand;
import com.command.member.PwChangeCommand;
import com.command.mrank.mRankViewCommand;
import com.command.mybook.MybookAddCommand;
import com.command.mybook.MybookAllCommand;
import com.command.mybook.MybookDeleteCommand;
import com.command.mybook.MybookListCommand;
import com.command.que.QueDeleteCommand;
import com.command.que.QueListCommand;
import com.command.que.QueModifyCommand;
import com.command.que.QueViewCommand;
import com.command.que.QueWriteCommand;
import com.command.review.ReviewDeleteCommand;
import com.command.review.ReviewWriteCommand;
import com.command.wishbook.WishbookAddCommand;
import com.command.wishbook.WishbookFormAddCommand;
import com.command.wishbook.WishbookFormCommand;
import com.command.wishbook.WishbookListCommand;
import com.command.wishbook.wishbookDeleteCommand;

/**
 * Servlet implementation class pc
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("actionDo");

		request.setCharacterEncoding("euc-kr");

		String viewPage = null;
		Command command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		

		
			// 멤버관련
		if (com.equals("/join.do")) {
			command = new JoinCommand();
			command.execute(request, response);
			viewPage = "memberJoinOk.jsp";
			
		} else if (com.equals("/idCheck.do")) {
			command = new IdCheckCommand();
			command.execute(request, response);
			viewPage = "idCheck.jsp";

		} else if (com.equals("/login.do")) {
			command = new LoginCommand();
			command.execute(request, response);
			viewPage = "memberLoginOk.jsp";

		} else if (com.equals("/memberList.do")) {
			command = new MemberListCommand();
			command.execute(request, response);
			viewPage = "memberList.jsp";

		} else if (com.equals("/memberSearch.do")) {
			command = new MemberSearchCommand();
			command.execute(request, response);
			viewPage = "memberSearch.jsp";

		} else if (com.equals("/memberDelete.do")) {
			command = new MemberDeleteCommand();
			command.execute(request, response);
			viewPage = "memberDeleteOk.jsp";
			
		} else if (com.equals("/memberView.do")) {
			command = new MemberViewCommand();
			command.execute(request, response);
			viewPage = "memberView.jsp";
			
		} else if (com.equals("/memberPwCheckOk.do")) {
			command = new PwCheckCommand();
			command.execute(request, response);
			viewPage = "memberPwCheckOk.jsp";
			
		} else if (com.equals("/memberModifyForm.do")) {
			command = new MemberViewCommand();
			command.execute(request, response);
			viewPage = "memberModifyForm.jsp";
			
		} else if (com.equals("/memberModifyOk.do")) {
			command = new MemberModifyCommand();
			command.execute(request, response);
			viewPage = "memberModifyOk.jsp";
			
		} else if (com.equals("/memberPwChangeOk.do")) {
			command = new PwChangeCommand();
			command.execute(request, response);
			viewPage = "memberPwChangeOk.jsp";
			
			
			// 도서 관련
		} else if (com.equals("/bookList.do")) {
			command = new BookListCommand();
			command.execute(request, response);
			viewPage = "bookList.jsp";

		} else if (com.equals("/bookSearch.do")) {
			command = new BookSearchCommand();
			command.execute(request, response);
			viewPage = "bookSearch.jsp";

		} else if (com.equals("/bookView.do")) {
			command = new BookViewCommand();
			command.execute(request, response);
			viewPage = "bookView.jsp";

		
			// 관리자
		} else if (com.equals("/bookListAdmin.do")) {
			command = new BookListCommand();
			command.execute(request, response);
			viewPage = "bookListAdmin.jsp";
			
		} else if (com.equals("/bookSearchAdmin.do")) {
			command = new BookSearchCommand();
			command.execute(request, response);
			viewPage = "bookSearchAdmin.jsp";

		} else if (com.equals("/bookAddOk.do")) {
			command = new BookAddCommand();
			command.execute(request, response);
			viewPage = "bookAddOk.jsp";

		} else if (com.equals("/bookViewAdmin.do")) {
			command = new BookViewCommand();
			command.execute(request, response);
			viewPage = "bookViewAdmin.jsp";

		} else if (com.equals("/bookDelete.do")) {
			command = new BookDeleteCommand();
			command.execute(request, response);
			viewPage = "bookDeleteOk.jsp";

		} else if (com.equals("/bookModifyForm.do")) {
			command = new BookViewCommand();
			command.execute(request, response);
			viewPage = "bookModifyForm.jsp";

		} else if (com.equals("/bookModifyOk.do")) {
			command = new BookModifyCommand();
			command.execute(request, response);
			viewPage = "bookModifyOk.jsp";

			
			
			// 내서재 관련
		} else if (com.equals("/mybookAdd.do")) {
			command = new MybookAddCommand();
			command.execute(request, response);
			viewPage = "mybookAddOk.jsp";

		} else if (com.equals("/mybookList.do")) {
			command = new MybookListCommand();
			command.execute(request, response);
			viewPage = "mybookList.jsp";

		} else if (com.equals("/mybookDelete.do")) {
			command = new MybookDeleteCommand();
			command.execute(request, response);
			viewPage = "mybookDeleteOk.jsp";

		} else if (com.equals("/mybookAll.do")) {
			command = new MybookAllCommand();
			command.execute(request, response);
			viewPage = "mybookAll.jsp";

			
			
			// 희망도서 관련
		} else if (com.equals("/wishbookForm.do")) {
			command = new WishbookFormCommand();
			command.execute(request, response);
			viewPage = "wishbookFormOk.jsp";

		} else if (com.equals("/wishbookList.do")) {
			command = new WishbookListCommand();
			command.execute(request, response);
			viewPage = "wishbookList.jsp";

		} else if (com.equals("/wishbookAddForm.do")) {
			command = new WishbookFormAddCommand();
			command.execute(request, response);
			viewPage = "wishbookAddForm.jsp";

		} else if (com.equals("/wishbookAdd.do")) { // 희망도서를 도서목록에 추가
			command = new WishbookAddCommand();
			command.execute(request, response);
			viewPage = "wishbookAddOk.jsp";

		} else if (com.equals("/wishbookDelete.do")) {
			command = new wishbookDeleteCommand();
			command.execute(request, response);
			viewPage = "wishbookDeleteOk.jsp";
			
			

			

			// 리뷰 관련
		} else if (com.equals("/reviewWrite.do")) {
			command = new ReviewWriteCommand();
			command.execute(request, response);
			viewPage = "reviewWriteOk.jsp";

		} else if (com.equals("/reviewDelete.do")) {
			command = new ReviewDeleteCommand();
			command.execute(request, response);
			viewPage = "reviewDeleteOk.jsp";

			
			
			// 공지사항 관련
		} else if (com.equals("/boardWrite.do")) {
			command = new BoardWriteCommand();
			command.execute(request, response);
			viewPage = "boardWriteOk.jsp";

		} else if (com.equals("/boardList.do")) {
			command = new BoardListCommand();
			command.execute(request, response);
			viewPage = "boardList.jsp";

		} else if (com.equals("/boardView.do")) {
			command = new BoardViewCommand();
			command.execute(request, response);
			viewPage = "boardView.jsp";

		} else if (com.equals("/boardModify.do")) {
			command = new BoardViewCommand();
			command.execute(request, response);
			viewPage = "boardModify.jsp";

		} else if (com.equals("/boardModifyOk.do")) {
			command = new BoardModifyCommand();
			command.execute(request, response);
			viewPage = "boardModifyOk.jsp";

		} else if (com.equals("/boardDelete.do")) {
			command = new BoardDeleteCommand();
			command.execute(request, response);
			viewPage = "boardDeleteOk.jsp";
			
			

			// Q&A 관련
		} else if (com.equals("/queWrite.do")) {
			command = new QueWriteCommand();
			command.execute(request, response);
			viewPage = "queWriteOk.jsp";

		} else if (com.equals("/queList.do")) {
			command = new QueListCommand();
			command.execute(request, response);
			viewPage = "queList.jsp";
			
		} else if (com.equals("/queViewCheck.do")) {
			command = new QueViewCommand();
			command.execute(request, response);
			viewPage = "queViewCheck.jsp";

		} else if (com.equals("/queView.do")) {
			command = new QueViewCommand();
			command.execute(request, response);
			command = new AnsViewCommand();
			command.execute(request, response);
			viewPage = "queView.jsp";

		} else if (com.equals("/queModify.do")) {
			command = new QueViewCommand();
			command.execute(request, response);
			viewPage = "queModify.jsp";

		} else if (com.equals("/queModifyOk.do")) {
			command = new QueModifyCommand();
			command.execute(request, response);
			viewPage = "queModifyOk.jsp";

		} else if (com.equals("/queDelete.do")) {
			command = new QueDeleteCommand();
			command.execute(request, response);
			viewPage = "queDeleteOk.jsp";
			
			
			
			// 답변 관련
		} else if (com.equals("/ansWrite.do")) {
			command = new QueViewCommand();
			command.execute(request, response);
			viewPage = "ansWrite.jsp";
			
		} else if (com.equals("/ansWriteOk.do")) {
			command = new AnsWriteCommand();
			command.execute(request, response);
			viewPage = "ansWriteOk.jsp";
			
		} else if (com.equals("/ansModify.do")) {
			command = new QueViewCommand();
			command.execute(request, response);
			command = new AnsViewCommand();
			command.execute(request, response);
			viewPage = "ansModify.jsp";
			
		} else if (com.equals("/ansModifyOk.do")) {
			command = new AnsModifyCommand();
			command.execute(request, response);
			viewPage = "ansModifyOk.jsp";
			
		} else if (com.equals("/ansDelete.do")) {
			command = new AnsDeleteCommand();
			command.execute(request, response);
			viewPage = "ansDeleteOk.jsp";
			
	
			
			
			// 메인 실행 시
		} else if (com.equals("/main.do")) { 
			command = new mRankViewCommand();
			command.execute(request, response);
			command = new bRankViewCommand();
			command.execute(request, response);
			command = new BoardListCommand();
			command.execute(request, response);
			command = new BookListCommand();
			command.execute(request, response);
			command = new BookRandomListCommand();
			command.execute(request, response);
			viewPage = "main.jsp";	
			
		}
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}
