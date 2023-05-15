package jpamvcexam.mainview;

import jpamvcexam.model.entity.EntityTest;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class EntityTestApp4 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        EntityTest et;
        em.getTransaction().begin();
        
        for(int i=51; i < 56; i++) {
        	et = new EntityTest();
        	et.setName("도우너"+i);
        	et.setAge(10+i);
        	et.setBirthday(LocalDateTime.now());
        	em.persist(et);
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.println("엔터키.....");
        scan.nextLine();  
        TypedQuery<EntityTest> q = em.createQuery("select t from EntityTest t", EntityTest.class);
    	List<EntityTest> list = q.getResultList();
    	list.stream().forEach(System.out::println);
    	
    	for(int i=101; i < 106; i++) {
        	et = new EntityTest();
        	et.setName("또치"+i);
        	et.setAge(10+i);
        	et.setBirthday(LocalDateTime.now());
        	em.persist(et);
        }    	
    	System.out.println("엔터키.....");
        scan.nextLine();  
        em.flush();

        q = em.createQuery("select t from EntityTest t", EntityTest.class);
        list = q.getResultList();
        list.stream().forEach(System.out::println);
        
        System.out.println("엔터키.....");
        scan.nextLine();  
        em.getTransaction().rollback(); // commit 하기 전 rollback을 하면 현재까지를 취소
        em.close();       
        factory.close();
        scan.close();
	}
}
