package jpamvcexam.mainview;

import jpamvcexam.model.entity.Member;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MemberTeamTest6 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        
        String jpql = "select m from Member m where m.team = null";
        
        TypedQuery<Member> q = em.createQuery(jpql, Member.class);
        List<Member> list = q.getResultList();
        
        System.out.println("팀이 설정되지 않은 데이터 갯수 : "+list.size());
        
        if(list.size() > 0) 
        	list.stream().forEach(x -> {em.remove(x);System.out.println("삭제함");});
        
        System.out.println("데이터 삭제~~ ");       
        em.getTransaction().commit();       
        em.close();
        factory.close();
	}
}
