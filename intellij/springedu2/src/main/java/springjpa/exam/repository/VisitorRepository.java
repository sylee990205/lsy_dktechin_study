package springjpa.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import springjpa.exam.entity.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Integer>{

	public List<Visitor> findByMemoContains(String keyword);	
	
}
