package com.example.springedu2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import springjpa.exam.entity.Emp;
import springjpa.exam.repository.EmpRepository;
import springjpa.exam.repository.EmpRepository2;

import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class JPA_EmpRepositoryTest {
    @Autowired
    private EmpRepository empR;

    @Test
    void list() {
    	List<Emp> list = empR.findAll();
    	list.stream().forEach(System.out::println);
    }
    @Test
    void list2() {
        List<Emp> list = empR.findAll(Sort.by("sal").descending());
        list.stream().forEach(System.out::println);
    }
}
