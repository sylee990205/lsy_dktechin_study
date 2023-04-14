package model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.domain.MeetingDTO;
import model.domain.ReplyDTO;

public class MeetingDAO {
	public List<MeetingDTO> listM() {
		Connection conn = MySQLConnect.connect();
		Statement stmt = null;
		ResultSet rs = null;
		List<MeetingDTO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT id,name, title, date_format(meetingdate, '%Y/%m/%d %H:%i') AS meetingdate FROM meeting");
			MeetingDTO vo = null;
			while (rs.next()) {
				vo = new MeetingDTO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setMeetingDate(rs.getString("meetingdate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs, conn);
		}
		return list;
	}

	public boolean insertM(MeetingDTO vo) {
		Connection conn = MySQLConnect.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO meeting (name, title, meetingdate) VALUES(?,?,?)");
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
		
			LocalDateTime d = LocalDateTime.parse(vo.getMeetingDate());
			pstmt.setTimestamp(3, Timestamp.valueOf(d));  // setDate()-날짜, setTimestamp()-날짜+시간
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("meeting insert 과정에서 오류 발생 " + e);
			return false;
		} finally {
			close(pstmt, null, conn);
		}
	}
	
	public boolean updateM(MeetingDTO vo) {
		Connection conn = MySQLConnect.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"update meeting set " + 
					"name = ?, " + 
					"title = ?, " + 
					"meetingdate = ? " + 
					"where id = ?");			
			
			LocalDateTime d = LocalDateTime.parse(vo.getMeetingDate());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setTimestamp(3, Timestamp.valueOf(d));  // setDate()-날짜, setTimestamp()-날짜+시간
			pstmt.setInt(4, vo.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("meeting insert 과정에서 오류 발생 " + e);
			return false;
		} finally {
			close(pstmt, null, conn);
		}
	}

	public List<MeetingDTO> searchM(String name) {
		Connection conn = MySQLConnect.connect();
		PreparedStatement pstmt = null;
		MeetingDTO vo = null;
		ResultSet rs = null;
		List<MeetingDTO> list = new ArrayList<>();
		System.out.println(name);
		try {
			pstmt = conn.prepareStatement(
					"SELECT id, name, title, date_format(meetingdate, '%Y/%m/%d %H:%i') AS md FROM meeting WHERE name = ?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new MeetingDTO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setMeetingDate(rs.getString("md"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs, conn);
		}
		return list;
	}

	public boolean deleteM(int id) {
		Connection conn = MySQLConnect.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("DELETE FROM meeting WHERE id = " + id);

			if (pstmt.executeUpdate() != 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.err.println("delete 과정에서 오류 발생 " + e);
			return false;
		} finally {
			close(pstmt, null, conn);
		}
	}

	public List<ReplyDTO> listReply(int refid) {
		Connection conn = MySQLConnect.connect();
		Statement stmt = null;
		ResultSet rs = null;
		List<ReplyDTO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id, name, content FROM reply where refid = " + refid);
			ReplyDTO vo = null;
			while (rs.next()) {
				vo = new ReplyDTO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setRefid(refid);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs, conn);
		}
		return list;
	}

	public boolean insertReply(ReplyDTO vo) {
		Connection conn = MySQLConnect.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO reply (name, content, refid) VALUES(?,?,?)");
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getRefid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("reply insert 과정에서 오류 발생 " + e);
			return false;
		} finally {
			close(pstmt, null, conn);
		}
	}

	private void close(Statement s, ResultSet r, Connection conn) {
		try {
			if (r != null)
				r.close();
			if (s != null)
				s.close();
			MySQLConnect.close(conn);
		} catch (SQLException e) {
			System.err.println("객체 close 과정에서 문제 발생" + e);
		}
	}
}
