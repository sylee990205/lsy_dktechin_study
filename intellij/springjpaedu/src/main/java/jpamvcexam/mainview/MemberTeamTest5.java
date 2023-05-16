package jpamvcexam.mainview;

import jpamvcexam.model.entity.Member;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class MemberTeamTest5 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        
        Member m = em.find(Member.class, 0); // id 는 알아서 입력
        em.remove(m);        
               
        System.out.println("데이터 삭제~~ ");       
        em.getTransaction().commit();       
        em.close();
        factory.close();
	}
}
