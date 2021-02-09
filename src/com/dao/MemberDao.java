package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dto.MemberDto;

public class MemberDao {
	private static MemberDao instance = new MemberDao();

	private MemberDao() { // singlton
	}

	public static MemberDao getInstance() {
		return instance;
	}

	// 커넥션풀
	private Connection getConnection() {

		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;

		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	// 회원가입
	public int insertMember(MemberDto dto) {
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "insert into b_member values (?,?,?,?,?,?,?)";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getBirth());
			pstmt.setString(5, dto.getGender());
			pstmt.setString(6, dto.geteMail());
			pstmt.setTimestamp(7, dto.getrDate());

			pstmt.executeUpdate();

			ri = 1;

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

	// 중복아이디 확인
	public int confirmId(String id) {
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select id from b_member where id = ?";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();

			if (set.next()) {
				ri = 1; // 아이디 존재
			} else {
				ri = 0; // 아이디 없음
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
		return ri;
	}

	// 로그인
	public int login(String id, String pw) {
		int ri = 0;
		String dbPw;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select pw from b_member where id = ?";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, id); // 이거 순서 증요

			set = pstmt.executeQuery();

			if (set.next()) {
				dbPw = set.getString("pw");
				if (dbPw.equals(pw)) {
					ri = 1; // 로그인 성공
				} else {
					ri = 0; // 비밀번호가 다름
				}
			} else {
				ri = -1; // 회원이 아님
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
		return ri;
	}

	// 모든 멤버 조회
	public ArrayList<MemberDto> memberList(int start, int end) {

		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from (SELECT * FROM ( SELECT rownum rnum, id, pw, name, birth, gender, eMail, rDate FROM b_member order by rdate desc) b_member where rnum <= ?) where rnum >= ?";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);

			pstmt.setInt(1, end);
			pstmt.setInt(2, start);

			set = pstmt.executeQuery();

			while (set.next()) {
				MemberDto dto = new MemberDto();

				dto.setId(set.getString("id"));
				dto.setPw(set.getString("pw"));
				dto.setName(set.getString("name"));
				dto.setBirth(set.getString("birth"));
				dto.setGender(set.getString("gender"));
				dto.seteMail(set.getString("eMail"));
				dto.setrDate(set.getTimestamp("rDate"));

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
	
	// 내정보 조회
	public MemberDto memberView(String id) {

		MemberDto dto = new MemberDto();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from b_member where id = ? ";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, id);

			set = pstmt.executeQuery();

			if (set.next()) {
				dto.setId(set.getString("id"));
				dto.setPw(set.getString("pw"));
				dto.setName(set.getString("name"));
				dto.setBirth(set.getString("birth"));
				dto.setGender(set.getString("gender"));
				dto.seteMail(set.getString("eMail"));
				dto.setrDate(set.getTimestamp("rDate"));
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

	// 멤버 검색
	public ArrayList<MemberDto> findInfo(String req, int index) {

		ArrayList<MemberDto> search = new ArrayList<MemberDto>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = null;

		try {
			connection = getConnection();

			if (index == 0) {
				query = "select * from b_member where id like ?";
			} else
				query = "select * from b_member where name like ?";

			pstmt = connection.prepareStatement(query);

			String setReq = "%" + req + "%";
			pstmt.setString(1, setReq);

			set = pstmt.executeQuery();

			while (set.next()) {

				MemberDto dto = new MemberDto();

				dto.setId(set.getString("id"));
				dto.setPw(set.getString("pw"));
				dto.setName(set.getString("name"));
				dto.setBirth(set.getString("birth"));
				dto.setGender(set.getString("gender"));
				dto.seteMail(set.getString("eMail"));
				dto.setrDate(set.getTimestamp("rDate"));

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

	// 멤버 삭제
	public int DeleteMember(String id) {
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "delete from b_member where id = ?";

		try {
			connection = getConnection();

			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, id);

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

	// 전체 멤버 수
	public int memberCount() {
		int cnt = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select count(*) from b_member";

		try {
			connection = getConnection();

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

	// 비밀번호 확인
	public int confirmPw(String id, String pw) {
		int ri = 0;

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;

		String query = "select * from b_member where id = ? and pw = ?";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			set = pstmt.executeQuery();

			if (set.next()) {
				ri = 1; // 비밀번호 일치
			} else {
				ri = 0; // 비밀번호 불일치
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
		return ri;
	}

	// 회원정보 수정
	public int MemberModify(MemberDto dto) {
	
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;

		String query = "update b_member set name = ?, birth = ?, gender = ?, eMail = ? where id = ?";

		try {
			
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBirth());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.geteMail());
			pstmt.setString(5, dto.getId());

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

	// 회원정보 수정
		public int PwModify(MemberDto dto) {
		
			int ri = 0;
			
			Connection connection = null;
			PreparedStatement pstmt = null;

			String query = "update b_member set pw = ? where id = ?";

			try {
				
				connection = getConnection();
				pstmt = connection.prepareStatement(query);
				
				pstmt.setString(1, dto.getPw());
				pstmt.setString(2, dto.getId());

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