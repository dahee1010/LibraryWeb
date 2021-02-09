package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.WishbookDto;

public class WishbookDao {

	DataSource dataSource;

	public WishbookDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 희망도서서재 추가
	public int wishbookAdd(String wbName, String wbWriter, String wbPublish, int wbYear) {
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		Timestamp wbDate = new Timestamp(System.currentTimeMillis());

		String query = "insert into b_wishbook (wbNum, wbName, wbWriter, wbPublish, wbYear, wbDate) values (wishbook_seq.nextval, ?, ?, ?, ?, ?)";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, wbName);
			pstmt.setString(2, wbWriter);
			pstmt.setString(3, wbPublish);
			pstmt.setInt(4, wbYear);
			pstmt.setTimestamp(5, wbDate);

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

	// 희망 도서 리스트
	public ArrayList<WishbookDto> wishbookList() {

		ArrayList<WishbookDto> dtos = new ArrayList<WishbookDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from b_wishbook order by wbNum desc";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			set = pstmt.executeQuery();

			while (set.next()) {
				int wbNum = set.getInt("wbNum");
				String wbName = set.getString("wbName");
				String wbWriter = set.getString("wbWriter");
				String wbPublish = set.getString("wbPublish");
				int wbYear = set.getInt("wbYear");
				Timestamp wbDate = set.getTimestamp("wbDate");

				WishbookDto dto = new WishbookDto(wbNum, wbName, wbWriter, wbPublish, wbYear, wbDate);
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

	// 희망 도서 상세 정보 폼
	public ArrayList<WishbookDto> wishbook(int wbNum) {

		ArrayList<WishbookDto> dtos = new ArrayList<WishbookDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		
		String query = "select * from b_wishbook where wbNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, wbNum);

			set = pstmt.executeQuery();

			while (set.next()) {
				wbNum = set.getInt("wbNum");
				String wbName = set.getString("wbName");
				String wbWriter = set.getString("wbWriter");
				String wbPublish = set.getString("wbPublish");
				int wbYear = set.getInt("wbYear");
				Timestamp wbDate = set.getTimestamp("wbDate");

				WishbookDto dto = new WishbookDto(wbNum, wbName, wbWriter, wbPublish, wbYear, wbDate);
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
	
	// 희망도서 삭제
		public int wishbookDelete(String wbNum) {
			
			int ri = 0;

			Connection connection = null;
			PreparedStatement pstmt = null;

			String query = "delete from b_wishbook where wbNum = ?";

			try {
				connection = dataSource.getConnection();

				pstmt = connection.prepareStatement(query);
				
				pstmt.setInt(1, Integer.parseInt(wbNum));

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
}
