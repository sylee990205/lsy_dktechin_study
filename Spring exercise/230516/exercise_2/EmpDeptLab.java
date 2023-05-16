package jpamvcexam.mainview;

import jpamvcexam.model.entity.Dept;
import jpamvcexam.model.entity.Emp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class EmpDeptLab {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        if(new Random().nextBoolean()){
            System.out.print("사원명을 입력해주세요: ");
            input = bufferedReader.readLine();
            TypedQuery<String> query = em.createQuery("select d.dname from Emp e join e.dept d where e.ename = :input", String.class);
            query.setParameter("input", input);
            List<String> deptList = query.getResultList();
            if (deptList.isEmpty()) {
                System.out.println("부서명을 찾을 수 없네요..ㅜㅜ");
            } else {
                deptList.stream().forEach(s -> {System.out.println(input+"님의 부서명은 " + s +"입니다...");});
            }
        } else {
            System.out.print("부서명을 입력해주세요: ");
            input = bufferedReader.readLine();
            TypedQuery<String> query = em.createQuery("select e.ename from Emp e join e.dept d where d.dname = :input", String.class);
            query.setParameter("input", input);
            List<String> empList = query.getResultList();
            if (empList.isEmpty()) {
                System.out.println("직원을 찾을 수 없네요..ㅜㅜ");
            } else {
                System.out.println(input + "부서의 직원들입니다...");
                empList.stream().forEach(System.out::println);
            }
        }
        em.close();
        factory.close();
    }
}
