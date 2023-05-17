package com.example.springedu2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springjpa.exam.entity.Member;
import springjpa.exam.repository.MemberTeamRepository;

import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class JPA_MemberTeamTest {
    @Autowired
    private MemberTeamRepository repo;
    
    @BeforeEach()
    void pr() {
    	System.out.println("==========================================================");
    }
    @Test
    @Order(1)
    void test1() {
    	List<Member> list = repo.aaa("겨울왕국");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(2)
    void test2() {
    	String teamName = repo.bbb("둘리");
    	System.out.println(teamName);    	
    }
    @Test
    @Order(3)
    void test3() {
    	List<Member> list = repo.findByUsername("짱아");
    	for(Member m : list) {
    		System.out.println(m.getId());    
    		System.out.println(m.getUsername());
    		System.out.println(m.getTeam());
    	}
    }
    @Test
    @Order(4)
    void test4() {
    	long num =repo.countByUsername("짱아");
    	System.out.println("짱아는 " + num + "명");    		
    }      
    @Test
    @Order(5)
    void test5() {
    	long num =repo.countBy();
    	System.out.println("전체 회원은 " + num + "명");    		
    }  

}
