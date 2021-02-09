package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.ReviewDto;

public class ReviewDao {

	DataSource dataSource;

	public ReviewDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 리뷰 작성
	public int reviewWrite(int bNum, String rId, String rContent, int rating) {
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "insert into b_review (bNum, rNum, rId, rContent, rating) values (?, review_seq.nextval, ?, ?, ?)";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, bNum);
			pstmt.setString(2, rId);
			pstmt.setString(3, rContent);
			pstmt.setInt(4, rating);

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

	// 리뷰 목록
	public ArrayList<ReviewDto> reviewList(int bNum) {

		ArrayList<ReviewDto> dtos = new ArrayList<ReviewDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from b_review where bNum = ? order by rnum desc";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, bNum);

			set = pstmt.executeQuery();

			while (set.next()) {
				bNum = set.getInt("bNum");
				int rNum = set.getInt("rNum");
				String rId = set.getString("rId");
				String rContent = set.getString("rContent");
				int rating = set.getInt("rating");

				ReviewDto dto = new ReviewDto(bNum, rNum, rId, rContent, rating);
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

	// 리뷰 삭제
	public int reviewDelete(int rNum) {
		
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "delete from b_review where rNum = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, rNum);

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
