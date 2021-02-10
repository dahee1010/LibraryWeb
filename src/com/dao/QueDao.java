package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.QueDto;

public class QueDao {

	DataSource dataSource;

	public QueDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 질문글 작성
	public int queWrite(String qId, String title, String content, Timestamp qDate, String open) {
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "insert into b_que (qNum, qId, title, content, qDate, hit, cnt, open) values (que_seq.nextval, ?, ?, ?, ?, 0, 0, ?)";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, qId);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setTimestamp(4, qDate);
			pstmt.setString(5, open);

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

	// 질문글 수정
	public int queModify(int qNum, String title, String content, String open) {

		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_que set title = ?, content = ?, open = ? where qNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, open);
			pstmt.setInt(4, qNum);

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

	// 질문글 삭제
	public int queDelete(int qNum) {

		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "delete from b_que where qNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, qNum);

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

	// 질문글 상세보기
	public QueDto contentView(int qNum) {
		upHit(qNum);

		QueDto dto = null;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from b_que where qNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, qNum);

			set = pstmt.executeQuery();

			if (set.next()) {
				qNum = set.getInt("qNum");
				String qId = set.getString("qId");
				String title = set.getString("title");
				String content = set.getString("content");
				Timestamp qDate = set.getTimestamp("qDate");
				int hit = set.getInt("hit");
				int cnt = set.getInt("cnt");
				String open = set.getString("open");

				dto = new QueDto(qNum, qId, title, content, qDate, hit, cnt, open);
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
	public ArrayList<QueDto> queList(int start, int end) {

		ArrayList<QueDto> dtos = new ArrayList<QueDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from (SELECT * FROM ( SELECT rownum rnum, qNum, qId, title, content, qDate, hit, cnt, open FROM (select * from b_que order by qNum desc) b_que) b_que where rnum <= ? ) where rnum >= ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, end);
			pstmt.setInt(2, start);

			set = pstmt.executeQuery();

			while (set.next()) {
				int qNum = set.getInt("qNum");
				String qId = set.getString("qId");
				String title = set.getString("title");
				String content = set.getString("content");
				Timestamp qDate = set.getTimestamp("qDate");
				int hit = set.getInt("hit");
				int cnt = set.getInt("cnt");
				String open = set.getString("open");

				QueDto dto = new QueDto(qNum, qId, title, content, qDate, hit, cnt, open);
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
	public int queCount() {
		int cnt = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select count(*) from b_que";

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
	private void upHit(int qNum) {

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_que set hit=(hit+1) where qNum = ?";
		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, qNum);

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
	
	// 답변 카운트 +1
	public void upCnt(int qNum) {

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_que set cnt=(cnt+1) where qNum = ?";
		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, qNum);

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
	
	//답변 카운트 -1
	public void downCnt(int qNum) {

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_que set cnt=(cnt-1) where qNum = ?";
		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, qNum);

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
