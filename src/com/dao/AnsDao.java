package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.AnsDto;

public class AnsDao {

	DataSource dataSource;

	public AnsDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// 답변글 작성
	public int ansWrite(int qNum, String qtitle, String content, Timestamp aDate) {
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "insert into b_ans (qNum, qtitle, aNum, content, aDate) values (?, ?, ans_seq.nextval, ?, ?)";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, qNum);
			pstmt.setString(2, qtitle);
			pstmt.setString(3, content);
			pstmt.setTimestamp(4, aDate);

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

	// 답변글 수정
	public int ansModify(int qNum, String content) {

		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_ans set content = ? where qNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, content);
			pstmt.setInt(2, qNum);

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

	// 답변글 삭제
	public int ansDelete(int qNum) {

		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "delete from b_ans where qNum = ?";

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

	// 답변글 상세보기
	public AnsDto contentView(int qNum) {
		
		AnsDto dto = null;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from b_ans where qNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, qNum);

			set = pstmt.executeQuery();

			if (set.next()) {
				qNum = set.getInt("qNum");
				String qTitle = set.getString("qTitle");
				int aNum = set.getInt("aNum");
				String content = set.getString("content");
				Timestamp aDate = set.getTimestamp("aDate");

				dto = new AnsDto(qNum, qTitle, aNum, content, aDate);
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
}
