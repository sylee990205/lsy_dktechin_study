package jpamvcexam.model.dao;

import jpamvcexam.model.vo.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDAO {
    private EntityManagerFactory factory;

    public StudentDAO() {
        super();
        factory = Persistence.createEntityManagerFactory("entitytest");
    }

    public boolean insertStudent(Student entity) {
        boolean result = true;
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            result = false;
        }
        em.close();
        return result;
    }

    public List<Student> getAllStudent() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Student> typedQuery = em.createQuery("select s from Student s", Student.class);
        List<Student> studentList = typedQuery.getResultList();
        em.close();
        return studentList;
    }

    public Student getScore(String name) {
        EntityManager em = factory.createEntityManager();
        Student student = em.find(Student.class, name);
        em.close();
        return student;
    }

    public boolean updateStudent(Student entity) {
        EntityManager em = factory.createEntityManager();
        boolean result = true;
        try {
            em.getTransaction().begin();
            Student oldStudent = em.find(Student.class, entity.getName());
            //oldStudent.setName(entity.getName()); -> 학생 이름을 수정하지않음
            oldStudent.setScore(entity.getScore());
            em.getTransaction().commit();
        } catch (Exception e) {
            result = false;
        }
        em.close();
        return result;
    }

    public boolean deleteStudent(String name) {
        EntityManager em = factory.createEntityManager();
        boolean result = true;
        try {
            em.getTransaction().begin();
            Student student = em.find(Student.class, name);
            em.remove(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            result = false;
        }
        em.close();
        return result;
    }

    public void close() {
        if (factory != null) {
            factory.close();
        }
    }
}
