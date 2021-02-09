package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.BoardDto;

public class BoardDao {

	DataSource dataSource;

	public BoardDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 공지사항 작성
	public int boardWrite(String wId, String title, String content, Timestamp wDate) {
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "insert into b_board (wNum, wId, title, content, wDate, hit) values (board_seq.nextval, ?, ?, ?, ?, 0)";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, wId);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setTimestamp(4, wDate);

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

	// 공지사항 수정
	public int boardModify(int wNum, String title, String content) {

		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_board set title = ?, content = ? where wNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, wNum);

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

	// 공지사항 삭제
	public int boardDelete(int wNum) {

		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "delete from b_board where wNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, wNum);

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

	// 공지사항 상세보기
	public BoardDto contentView(int wNum) {
		upHit(wNum);

		BoardDto dto = null;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from b_board where wNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, wNum);

			set = pstmt.executeQuery();

			if (set.next()) {
				wNum = set.getInt("wNum");
				String wId = set.getString("wId");
				String title = set.getString("title");
				String content = set.getString("content");
				Timestamp wDate = set.getTimestamp("wDate");
				int hit = set.getInt("hit");

				dto = new BoardDto(wNum, wId, title, content, wDate, hit);
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

	// 전체글과 페이징 처리
	public ArrayList<BoardDto> boardList(int start, int end) {

		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from (SELECT * FROM ( SELECT rownum rnum, wNum, wId, title, content, wDate, hit FROM b_board order by wNum desc) b_board where rnum <= ?) where rnum >= ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, end);
			pstmt.setInt(2, start);

			set = pstmt.executeQuery();

			while (set.next()) {
				int wNum = set.getInt("wNum");
				String wId = set.getString("wId");
				String title = set.getString("title");
				String content = set.getString("content");
				Timestamp wDate = set.getTimestamp("wDate");
				int hit = set.getInt("hit");

				BoardDto dto = new BoardDto(wNum, wId, title, content, wDate, hit);
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

	// 전체 게시물 수
	public int boardCount() {
		int cnt = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select count(*) from b_board";

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

	// 조회수 올리기
	private void upHit(int wNum) {

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_board set hit=(hit+1) where wNum = ?";
		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, wNum);

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
}
