package com.example.springedu2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import springjpa.exam.entity.Emp;
import springjpa.exam.repository.EmpRepository2;

import javax.transaction.Transactional;
import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
@DataJpaTest
public class JPA_EmpRepository2Test {
    @Autowired
    private EmpRepository2 empR;
    
    @BeforeEach()
    void pr() {
    	System.out.println("==========================================================");
    }
    
    @Test
    @Order(1)
    //@Rollback(false) // rollback이 기본임. DML 문 수행한 후에 rollback 하고싶지 않다면  
    @Transactional
    void save() {
    	Emp entity = new Emp();
    	entity.setEmpno(1234);
    	entity.setEname("유니코");
    	entity.setJob("강의");
    	entity.setMgr("7566");
    	entity.setHiredate(new java.sql.Date(System.currentTimeMillis()));
    	entity.setSal(3000);
    	entity.setComm(300);
    	entity.setDeptno(30);
    	empR.save(entity);
    	List<Emp> list = empR.findAll();
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(24)
    void list() {
    	List<Emp> list = empR.findAll();
    	list.stream().forEach(System.out::println);
    }
   @Test
   @Order(2)
    void byId() {
    	Emp entity = empR.findById(7788).get();
    	System.out.println(entity);
    }
    @Test
    @Order(3)
    void byName() {
    	List<Emp> list = empR.findByEname("SMITH");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(4)
    void byNameIgnoreCase() {
    	List<Emp> list = empR.findByEnameIgnoreCase("smith");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(5)
    void byJob() {
    	List<Emp> list = empR.findByJob("SALESMAN");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(6)
    void byJobOrDeptno() {
    	List<Emp> list = empR.findByJobOrDeptno("MANAGER", 20);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(7)
    void byJobAndDeptno() {
    	List<Emp> list = empR.findByJobAndDeptno("MANAGER", 20);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(8)
    void byDistinctByJob() {
    	List<Emp> list = empR.findDistinctByJob("SALESMAN");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(9)
    void byDeptno() {
    	List<Emp> list = empR.findByDeptno(30);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(10)
    void bySalGreaterThan() {
    	List<Emp> list = empR.findBySalGreaterThan(3000);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(11)
    void bySalGreaterThanEqual() {
    	List<Emp> list = empR.findBySalGreaterThanEqual(3000);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(12)
    void bySalLessThan() {
    	List<Emp> list = empR.findBySalLessThan(3000);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(13)
    void bySalLessThanEqual() {
    	List<Emp> list = empR.findBySalGreaterThanEqual(3000);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(14)
    void bySalBetween() {
    	List<Emp> list = empR.findBySalBetween(2000, 3000);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(15)
    void byCommNull() {
    	List<Emp> list = empR.findByCommNull();
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(16)
    void byCommNotNull() {
    	List<Emp> list = empR.findByCommNotNull();
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(17)
    void byHiredateAfter() {
    	List<Emp> list = empR.findByHiredateAfter(java.sql.Date.valueOf("1981-12-31"));
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(18)
    void byHiredateBefore() {
    	List<Emp> list = empR.findByHiredateBefore(java.sql.Date.valueOf("1981-12-31"));
    	list.stream().forEach(System.out::println);
    }
   
    @Test
    @Order(19)
    void byEnameStartsWith() {
    	List<Emp> list = empR.findByEnameStartsWith("M");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(20)
    void byEnameContains() {
    	List<Emp> list = empR.findByEnameContains("LA");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(21)
    void byDeptnoOrderBySalDesc() {
    	List<Emp> list = empR.findByDeptnoOrderBySalDesc(20);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(22)
    void byTop3DeptnoOrderBySalDesc() {
    	List<Emp> list = empR.findTop3ByDeptnoOrderBySalDesc(20);
    	list.stream().forEach(System.out::println);
    }
}
