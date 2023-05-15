package jpamvcexam.mainview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HelloJpa2 {
    public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
        System.out.println("EntityManagerFactory 객체 : " + factory.getClass().getName());
        EntityManager em = factory.createEntityManager();   
        System.out.println("EntityManager 객체 : " + em.getClass().getName());
        em.close();
        factory.close();
    }
}
