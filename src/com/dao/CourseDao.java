package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.CourseDto;

public class CourseDao {

	DataSource dataSource;

	public CourseDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 년과 달이 맞는 일정만 가지고 오기
	public ArrayList<CourseDto> courseList(int year, int month) {

		ArrayList<CourseDto> dtos = new ArrayList<CourseDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from b_course where year = ? and month = ?";

		try {
			connection = dataSource.getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, year);
			pstmt.setInt(2, month);

			set = pstmt.executeQuery();

			while (set.next()) {
				int cNum = set.getInt("cNum");
				String category = set.getString("category");
				String lecName = set.getString("lecName");
				String instruc = set.getString("instruc");
				String object = set.getString("object");
				year = set.getInt("year");
				month = set.getInt("month");
				int day = set.getInt("day");
				String startTime = set.getString("startTime");
				String endTime = set.getString("endTime");
				int max = set.getInt("max");
				int applyCnt = set.getInt("applyCnt");
				int state = set.getInt("state");

				CourseDto dto = new CourseDto(cNum, category, lecName, instruc, object, year, month, day, startTime, endTime, max, applyCnt, state);
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
