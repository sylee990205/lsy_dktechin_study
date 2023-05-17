package springjpa.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springjpa.exam.entity.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Integer>{
	public List<Meeting> findByTitleContains(String keyword);	
	public List<Meeting> findByName(String name);
}
