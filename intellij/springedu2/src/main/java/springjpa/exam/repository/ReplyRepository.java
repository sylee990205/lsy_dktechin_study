package springjpa.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springjpa.exam.entity.Meeting;
import springjpa.exam.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{

	public List<Reply> findByRefid(Meeting vo);	
	
}
