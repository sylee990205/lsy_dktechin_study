package springjpa.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springjpa.exam.entity.Member;


public interface MemberTeamRepository extends JpaRepository<Member, Integer>{
	
	@Query("select m from Member m join m.team t where t.teamname = :tn")
	public List<Member> aaa(@Param("tn") String tname);
	@Query("select t.teamname from Member m join m.team t where m.username = :un")
	public String bbb(@Param("un") String uname);
	
	public List<Member> findByUsername(String username);
	public Long countByUsername(String username);
	public Long countBy();
}
