package day16.exercise.mvclab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day16.mvc.MySQLConnect;

public class StudentDAO {
	public boolean insertStudent(StudentDTO dto) {
		Connection conn = MySQLConnect.connect();
		int result = 0;
		try(PreparedStatement ptmt = conn.prepareStatement("INSERT INTO student VALUES (?, ?)");){
			ptmt.setString(1, dto.getName());
			ptmt.setInt(2, dto.getScore());
			result = ptmt.executeUpdate();
			if(result == 0)
				return false;
		}catch(SQLException se) {
			se.printStackTrace();
		}
		MySQLConnect.close(conn);
		return true;
	}
	
	public List<StudentDTO> getAllStudent(){
		Connection conn = MySQLConnect.connect();
		List<StudentDTO> slist = null;
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT name, score FROM student");){
			slist = new ArrayList<StudentDTO>();
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setName(rs.getString("name"));
				dto.setScore(rs.getInt("score"));
				slist.add(dto);
			}
			
		}catch (SQLException se) {
			se.printStackTrace();
		}
		MySQLConnect.close(conn);
		return slist;
	}
	
	public int getScore(StudentDTO dto) {
		Connection conn = MySQLConnect.connect();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT score FROM student WHERE name = '" + dto.getName() + "'");){
			if(rs.next()) 
				return rs.getInt("score");
		}catch (SQLException se) {
			se.printStackTrace();
		}
		MySQLConnect.close(conn);
		return -1;
	}
	public boolean updateStudent(StudentDTO dto) {
		Connection conn = MySQLConnect.connect();
		int result = 0;
		try(PreparedStatement ptmt = conn.prepareStatement("UPDATE student SET name = ?, score = ? WHERE name = '" + dto.getName() + "'")){
			ptmt.setString(1, dto.getName());
			ptmt.setInt(2, dto.getScore());
			result = ptmt.executeUpdate();
			if(result == 0) 
				return false;
		}catch (SQLException se) {
			se.printStackTrace();
		}
		MySQLConnect.close(conn);
		return true;
	}
    
	public boolean deleteStudent(StudentDTO dto) {
		Connection conn = MySQLConnect.connect();
		int result = 0;
		try(PreparedStatement ptmt = conn.prepareStatement("DELETE FROM student WHERE name = ?")){
			ptmt.setString(1, dto.getName());
			result = ptmt.executeUpdate();
			if(result == 0)
				return false;
		}catch (SQLException se) {
			se.printStackTrace();
		}
		MySQLConnect.close(conn);
		return true;
	}
	
}
