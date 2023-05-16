package jpamvcexam.mainview;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class MemberTeamTest4_1 {
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
        List<String> teamName = q.getResultList();

        if (!teamName.isEmpty()) {
            System.out.printf("%s님의 팀명은 %s입니다...\n", inputName, teamName);
        } else {
            System.out.println("팀을 찾을 수 없네요..ㅜㅜ ");
        }

        em.close();
        factory.close();
    }
}
