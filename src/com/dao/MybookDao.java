package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.MybookDto;

public class MybookDao {

	DataSource dataSource;

	public MybookDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 내서재 추가
	public int insertMybook(int bNum, String mbId, String mbName, String mbWriter) {
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		Timestamp mbDate = new Timestamp(System.currentTimeMillis());
		Timestamp mbRdate = new Timestamp(System.currentTimeMillis() + 604800000); // 일주일 후로 반납일 자동설정

		String query = "insert into b_mybook (bNum, mbNum, mbId, mbName, mbWriter, mbDate, mbRdate, exten) values (?, mybook_seq.nextval, ?, ?, ?, ?, ?, 0)";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, bNum);
			pstmt.setString(2, mbId);
			pstmt.setString(3, mbName);
			pstmt.setString(4, mbWriter);
			pstmt.setTimestamp(5, mbDate);
			pstmt.setTimestamp(6, mbRdate);

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

	// 내서재 아이디별 추출 리스트
	public ArrayList<MybookDto> mybookList(String mbId) {

		ArrayList<MybookDto> dtos = new ArrayList<MybookDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null; // select문 결과를 저장하는 객체

		String query = "select * from b_mybook where mbId = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, mbId);

			set = pstmt.executeQuery();

			while (set.next()) {
				int bNum = set.getInt("bNum");
				int mbNum = set.getInt("mbNum");
				mbId = set.getString("mbId");
				String mbName = set.getString("mbName");
				String mbWriter = set.getString("mbWriter");
				Timestamp mbDate = set.getTimestamp("mbDate");
				Timestamp mbRdate = set.getTimestamp("mbRdate");
				int exten = set.getInt("exten");

				MybookDto dto = new MybookDto(bNum, mbNum, mbId, mbName, mbWriter, mbDate, mbRdate, exten);
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

	// 내서재 삭제
	public int mybookDelete(String mbNum) {

		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "delete from b_mybook where mbNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(mbNum));

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
	
	// 대출 연장
	public int mybookExten(int mbNum) {

		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_mybook set mbRdate=(mbRdate+7), exten=1 where mbNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, mbNum);

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

	// 전체 대출 도서 조회
	public ArrayList<MybookDto> mybookAll(int start, int end) {

		ArrayList<MybookDto> dtos = new ArrayList<MybookDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from (SELECT * FROM ( SELECT rownum rnum, bNum, mbNum, mbId, mbName, mbWriter, mbDate, mbRdate, exten FROM b_mybook order by mbNum) b_mybook where rnum <= ?) where rnum >= ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, end);
			pstmt.setInt(2, start);

			set = pstmt.executeQuery();

			while (set.next()) {
				int bNum = set.getInt("bNum");
				int mbNum = set.getInt("mbNum");
				String mbId = set.getString("mbId");
				String mbName = set.getString("mbName");
				String mbWriter = set.getString("mbWriter");
				Timestamp mbDate = set.getTimestamp("mbDate");
				Timestamp mbRdate = set.getTimestamp("mbRdate");
				int exten = set.getInt("exten");

				MybookDto dto = new MybookDto(bNum, mbNum, mbId, mbName, mbWriter, mbDate, mbRdate, exten);
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

	// 전체 대출수
	public int mybookCount() {
		int cnt = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select count(*) from b_mybook";

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
}
