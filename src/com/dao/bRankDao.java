package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.bRankDto;

public class bRankDao {

	DataSource dataSource;

	public bRankDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 랭킹에 이미 도서가 있는지 확인
	public int confirmBook(int bNum) {
		int bookOk = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select bNum from b_brank where bNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, bNum);

			set = pstmt.executeQuery();

			if (set.next()) {
				bookOk = 1; // 도서 존재
			} else {
				bookOk = 0; // 도서 없음
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
		return bookOk;
	}

	// 도서가 랭킹서비스에 있다면 대출횟수 업데이트
	public void bRankUpadate(int bNum) {

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_brank set cnt=(cnt+1) where bNum = ?";

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

	// 랭킹서비스에 도서가 없다면 도서정보 추가 후 대출횟수 초기화
	public void bRankInsert(int bNum, String bName, String bWriter, String bImg) {

		int bookOk = confirmBook(bNum);

		System.out.println(bookOk);

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "insert into b_brank(bNum, bName, bWriter, bImg, cnt) values (?, ?, ?, ?, 1)";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, bNum);
			pstmt.setString(2, bName);
			pstmt.setString(3, bWriter);
			pstmt.setString(4, bImg);

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

	// 랭킹 리스트
	public ArrayList<bRankDto> bookRank() {

		ArrayList<bRankDto> dtos = new ArrayList<bRankDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from (select * from b_brank order by cnt desc)";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			set = pstmt.executeQuery();

			while (set.next()) {
				int bNum = set.getInt("bNum");
				String bName = set.getString("bName");
				String bWriter = set.getString("bWriter");
				String bImg = set.getString("bImg");
				int cnt = set.getInt("cnt");

				bRankDto dto = new bRankDto(bNum, bName, bWriter, bImg, cnt);
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