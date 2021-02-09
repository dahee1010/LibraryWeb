package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.mRankDto;

public class mRankDao {

	DataSource dataSource;

	public mRankDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 랭킹에 이미 아이디가 있는지 확인
	public int confirmId(String id) {
		int idOk = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select id from b_mrank where id = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, id);

			set = pstmt.executeQuery();

			if (set.next()) {
				idOk = 1; // 아이디 존재
			} else {
				idOk = 0; // 아이디 없음
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
		return idOk;
	}

	// 아이디가 랭킹서비스에 있다면 대출횟수 업데이트, 아이디가 없다면 아이디 추가 후 대출횟수 초기화
	public void mRankService(String id) {
		
		int idOk = confirmId(id); 
		
		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = null;

		try {
			connection = dataSource.getConnection();

			if (idOk == 1) {
				query = "update b_mrank set cnt=(cnt+1) where id = ?";  
			} else
				query = "insert into b_mrank(id, cnt) values (?, 1)"; 

				pstmt = connection.prepareStatement(query);

			pstmt.setString(1, id);

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
	public ArrayList<mRankDto> memberRank() {

		ArrayList<mRankDto> dtos = new ArrayList<mRankDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from (select * from b_mrank order by cnt desc) where rownum <= 5";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			set = pstmt.executeQuery();

			while (set.next()) {
				String id = set.getString("id");
				int cnt = set.getInt("cnt");

				mRankDto dto = new mRankDto(id, cnt);
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
