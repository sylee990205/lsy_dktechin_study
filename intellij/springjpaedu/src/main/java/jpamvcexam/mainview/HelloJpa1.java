package jpamvcexam.mainview;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HelloJpa1 {
    public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
    	System.out.println("EntityManagerFactory 객체 : " + factory.getClass().getName());    	
        factory.close();
    }
}
