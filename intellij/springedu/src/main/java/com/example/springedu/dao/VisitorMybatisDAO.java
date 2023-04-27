package com.example.springedu.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.springedu.domain.VisitorDTO;
@Repository
public class VisitorMybatisDAO {	
	@Autowired
	SqlSession session;	
	public List<VisitorDTO> list() {
		List<VisitorDTO> list = null;
		try {
			String statement = "resource.VisitorMapper.selectVisitor";
			list = session.selectList(statement);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	public VisitorDTO one(int id) {
		VisitorDTO vo = null;
		try {
			String statement = "resource.VisitorMapper.selectVisitorOne";
			vo = session.selectOne(statement, id);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return vo;
	}
	
	public List<VisitorDTO> search(String keyword) {
		List<VisitorDTO> list = null;
		try {			
			String statement = "resource.VisitorMapper.searchVisitor";
			list = session.selectList(statement, keyword);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;		
	}
	
	public boolean insert(VisitorDTO visitor) {
		boolean result = false;
		try {
			String statement = "resource.VisitorMapper.insertVisitor";
			session.insert(statement, visitor);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public boolean delete(String id) {
		boolean result = false;
		try {			
			String statement = "resource.VisitorMapper.deleteVisitor";
			session.delete(statement, Integer.parseInt(id));
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public boolean update(VisitorDTO visitor) {
		boolean result = false;
		try {			
			String statement = "resource.VisitorMapper.updateVisitor";
			session.update(statement, visitor);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
}
