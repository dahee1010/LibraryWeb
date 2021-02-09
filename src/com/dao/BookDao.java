package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.BookDto;

public class BookDao {

	DataSource dataSource;

	public BookDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 전체 도서와 페이징 처리
	public ArrayList<BookDto> bookList(int start, int end) {

		ArrayList<BookDto> dtos = new ArrayList<BookDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null; // select문 결과를 저장하는 객체

		String query = "select * from (SELECT * FROM ( SELECT rownum rnum, bookNum, bookName, writer, publish, year, code, bCnt, cnt, bookimg FROM b_book order by bookNum desc) b_book where rnum <= ?) where rnum >= ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, end);
			pstmt.setInt(2, start);

			set = pstmt.executeQuery();

			while (set.next()) {
				int bookNum = set.getInt("bookNum");
				String bookName = set.getString("bookName");
				String writer = set.getString("writer");
				String publish = set.getString("publish");
				int year = set.getInt("year");
				String code = set.getString("code");
				int bCnt = set.getInt("bCnt");
				int cnt = set.getInt("cnt");
				String bookimg = set.getString("bookimg");
				
				BookDto dto = new BookDto(bookNum, bookName, writer, publish, year, code, bCnt, cnt, bookimg);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	// 검색별 도서와 페이징 처리
	public ArrayList<BookDto> findInfo(String req, int index, int start, int end) {

		ArrayList<BookDto> search = new ArrayList<BookDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = null;

		try {
			connection = dataSource.getConnection();

			if (index == 0) {
				query = "select * from (SELECT * FROM ( SELECT rownum rnum, bookNum, bookName, writer, publish, year, code, bCnt, cnt, bookimg FROM b_book where bookName like ?) b_book where rnum <= ?) where rnum >= ?";
			} else if (index == 1) {
				query = "select * from (SELECT * FROM ( SELECT rownum rnum, bookNum, bookName, writer, publish, year, code, bCnt, cnt, bookimg FROM b_book where writer like ?) b_book where rnum <= ?) where rnum >= ?";
			} else
				query = "select * from (SELECT * FROM ( SELECT rownum rnum, bookNum, bookName, writer, publish, year, code, bCnt, cnt, bookimg FROM b_book where publish like ?) b_book where rnum <= ?) where rnum >= ?";

			pstmt = connection.prepareStatement(query);

			String setReq = "%" + req + "%";

			pstmt.setString(1, setReq);
			pstmt.setInt(2, end);
			pstmt.setInt(3, start);

			set = pstmt.executeQuery();

			while (set.next()) {
				int bookNum = set.getInt("bookNum");
				String bookName = set.getString("bookName");
				String writer = set.getString("writer");
				String publish = set.getString("publish");
				int year = set.getInt("year");
				String code = set.getString("code");
				int bCnt = set.getInt("bCnt");
				int cnt = set.getInt("cnt");
				String bookimg = set.getString("bookimg");

				BookDto dto = new BookDto(bookNum, bookName, writer, publish, year, code, bCnt, cnt, bookimg);
				search.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return search;
	}

	// 전체 도서 수
	public int bookAllCount() {
		int cnt = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select count(*) from b_book";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			set = pstmt.executeQuery();

			set.next();

			cnt = set.getInt("count(*)");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}

	// 검색별 도서수
	public int bookCount(String req, int index) {
		int cnt = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = null;

		try {
			connection = dataSource.getConnection();

			if (index == 0) {
				query = "select count(*) from b_book where bookName like ?";
			} else if (index == 1) {
				query = "select count(*) from b_book where writer like ?";
			} else
				query = "select count(*) from b_book where publish like ?";

			pstmt = connection.prepareStatement(query);

			String setReq = "%" + req + "%";
			pstmt.setString(1, setReq);

			set = pstmt.executeQuery();

			set.next();

			cnt = set.getInt("count(*)");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}

	// 도서 상세보기
	public BookDto contentView(int bookNum) {

		BookDto dto = null;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from b_book where bookNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, bookNum);
			
			set = pstmt.executeQuery();

			if (set.next()) {
				bookNum = set.getInt("bookNum");
				String bookName = set.getString("bookName");
				String writer = set.getString("writer");
				String publish = set.getString("publish");
				int year = set.getInt("year");
				String code = set.getString("code");
				int bCnt = set.getInt("bCnt");
				int cnt = set.getInt("cnt");
				String bookimg = set.getString("bookimg");

				dto = new BookDto(bookNum, bookName, writer, publish, year, code, bCnt, cnt, bookimg);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	// 도서 추가
	public int bookAdd(String bookName, String writer, String publish, int year, String code, int bCnt, int cnt, String bookimg) {
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "insert into b_book (bookNum, bookName, writer, publish, year, code, bCnt, cnt, bookimg) values (book_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, bookName);
			pstmt.setString(2, writer);
			pstmt.setString(3, publish);
			pstmt.setInt(4, year);
			pstmt.setString(5, code);
			pstmt.setInt(6, bCnt);
			pstmt.setInt(7, cnt);
			pstmt.setString(8, bookimg);

			ri = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}

	// 도서 삭제
	public int bookDelete(int bookNum) {

		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "delete from b_book where bookNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, bookNum);

			ri = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}

	// 도서 수정
	public int bookModify(int bookNum, String bookName, String writer, String publish, int year, String code,
			int bCnt, String bookimg) {

		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_book set bookName = ?, writer = ?, publish = ?, year = ?, code = ?, bCnt = ?, bookimg = ? where bookNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, bookName);
			pstmt.setString(2, writer);
			pstmt.setString(3, publish);
			pstmt.setInt(4, year);
			pstmt.setString(5, code);
			pstmt.setInt(6, bCnt);
			pstmt.setString(7, bookimg);
			pstmt.setInt(8, bookNum);

			ri = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}

	// 책 대출시 대출횟수 +1 해주기
	public void loanBook(int bNum) {

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_book set cnt=(cnt+1) where bookNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, bNum);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 책 반납시 대출횟수 -1 해주기
	public void returnBook(int bNum) {

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_book set cnt=(cnt-1) where bookNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, bNum);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// 랜덤 도서 리스트 -- 추천도서용
	public ArrayList<BookDto> radomBook() {

		ArrayList<BookDto> dtos = new ArrayList<BookDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select  * from b_book order by dbms_random.value";
		
		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			set = pstmt.executeQuery();

			while (set.next()) {
				int bookNum = set.getInt("bookNum");
				String bookName = set.getString("bookName");
				String writer = set.getString("writer");
				String publish = set.getString("publish");
				int year = set.getInt("year");
				String code = set.getString("code");
				int bCnt = set.getInt("bCnt");
				int cnt = set.getInt("cnt");
				String bookimg = set.getString("bookimg");

				BookDto dto = new BookDto(bookNum, bookName, writer, publish, year, code, bCnt, cnt, bookimg);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
}