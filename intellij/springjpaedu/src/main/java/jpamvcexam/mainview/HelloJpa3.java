package jpamvcexam.mainview;

import jpamvcexam.model.vo.EmpVO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class HelloJpa3 {
	@SuppressWarnings("unchecked")
    public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("select t from EmpVO t", EmpVO.class);
        List<EmpVO> empVOList = q.getResultList();
        for (Object vo : empVOList) {
            System.out.println(vo);
        }
        System.out.println("데이터 갯수 : " + empVOList.size());
        em.close();
        factory.close();
    }
}
