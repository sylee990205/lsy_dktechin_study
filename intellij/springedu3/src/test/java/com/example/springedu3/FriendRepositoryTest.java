package com.example.springedu3;

import com.example.springedu3.entity.Friend;
import com.example.springedu3.repository.FriendRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class FriendRepositoryTest {
    @Autowired
    private FriendRepository fr;
    @Test
    @Rollback(false)
    @Transactional
    void save() {
    	Friend entity = new Friend();
        entity.setName("둘리");
        fr.save(entity);
        entity = new Friend();
        entity.setName("또치");
        fr.save(entity);
        entity = new Friend();
        entity.setName("도우너");
        fr.save(entity);
    	List<Friend> list = fr.findAll();
    	list.stream().forEach(System.out::println);
    }
}
