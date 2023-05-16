package jpamvcexam.mainview;

import jpamvcexam.model.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class MemberTeamTest2 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        
        Scanner scan = new Scanner(System.in);
        System.out.print("팀명을 입력하세요 : ");
        String inputName = scan.nextLine();
        scan.close();
        
        String jpql = "select m from Member m join m.team t where t.teamName = :tn";
        
        TypedQuery<Member> q = em.createQuery(jpql, Member.class);
        q.setParameter("tn", inputName);
        List<Member> list = q.getResultList();
        
        if (list.size() != 0) {
        	list.stream().forEach(System.out::println);
        } else {
        	System.out.printf("%s 팀에는 팀원이 없습니다.%n", inputName);
        }
        em.close();
        factory.close();
	}
}
