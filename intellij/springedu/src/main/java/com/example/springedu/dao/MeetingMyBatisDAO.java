package com.example.springedu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springedu.domain.MeetingDTO;
import com.example.springedu.domain.ReplyVO;
@Repository
public class MeetingMyBatisDAO {
	@Autowired
	SqlSession session = null;	
	public List<MeetingDTO> listM(){
		String statement = "resource.MeetingMapper.selectMeeting";
		List<MeetingDTO> list = session.selectList(statement);
		return list;
	}
	
/*	public MeetingDTO oneM(){
		String statement = "resource.MeetingMapper.selectOneMeeting";
		MeetingDTO vo = session.selectOne(statement);
		return vo;
	}*/
	
	public List<MeetingDTO> searchM1(String keyword){
		String statement = "resource.MeetingMapper.searchMeetingK";
		List<MeetingDTO> list = session.selectList(statement, keyword);
        return list;
	}

	public List<MeetingDTO> searchM2(String name){
		String statement = "resource.MeetingMapper.searchMeetingN";
		List<MeetingDTO> list = session.selectList(statement, name);
		return list;
	}
	
	public boolean insertM(MeetingDTO vo) {
		boolean result = true;
		String statement = "resource.MeetingMapper.insertMeeting";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
	
	public boolean deleteM(int id) {
		boolean result = true;
		String statement = "resource.MeetingMapper.deleteMeeting";
		if(session.delete(statement, id) != 1)
			result = false;
		return result;
	}
	
	public boolean updateM(MeetingDTO vo) {
		boolean result = true;
		String statement = "resource.MeetingMapper.updateMeeting";
		if(session.update(statement, vo) != 1)
			result = false;
		return result;	
	}	
	public List<ReplyVO> listReply(int refid) {
		String statement = "resource.MeetingMapper.replySelectMeeting";
		List<ReplyVO> list = session.selectList(statement, refid);
        return list;		
	}

	public boolean insertReply(ReplyVO vo) {
		boolean result=true;
		String statement = "resource.MeetingMapper.replyInsertMeeting";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
}
