package jpamvcexam.mainview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class MemberTeamTest4 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        Scanner scan = new Scanner(System.in);
        System.out.print("멤버명을 입력하세요 : ");
        String inputName = scan.nextLine();
        scan.close();
             
        String jpql = "select t.teamName from Member m join m.team t where m.username = :un";
        
        TypedQuery<String> q = em.createQuery(jpql, String.class);
        q.setParameter("un", inputName);
        String teamName = q.getSingleResult();
        
        if (teamName == null) {
        	System.out.print("팀을 찾을 수 없네요..ㅜㅜ ");
        } else {
        	System.out.printf("%s님의 팀명은 %s입니다...\n", inputName, teamName);
        }
        em.close();
        factory.close();
	}
}
