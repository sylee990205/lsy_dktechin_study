package com.example.springedu2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import springrest.exam.entity.Friend;
import springrest.exam.repository.FriendRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Transactional
@Rollback(value = false)
public class FriendTest {
    @Autowired
    private FriendRepository repository;

    @Test
    public void insert() {
        Friend friend1 = Friend.builder().fname("소영").fage(25).build();
        Friend friend2 = Friend.builder().fname("소영").fage(25).build();
        Friend friend3 = Friend.builder().fname("소영").fage(25).build();
        Friend friend4 = Friend.builder().fname("소영").fage(25).build();

        repository.save(friend1);
        repository.save(friend2);
        repository.save(friend3);
        repository.save(friend4);
    }

    @Test
    public void readAll() {
        List<Friend> list = repository.findAll();
        list.stream().forEach(System.out::println);
    }

    @Test
    public void readById() {
        Friend friend = repository.findById(5).get();
        System.out.println(friend);
    }

    @Test
    public void readByFname() {
        List<Friend> friends = repository.findByFname("소영");
        friends.stream().forEach(System.out::println);
    }

    @Test
    public void readByFage() {
        List<Friend> friends = repository.findByFage(25);
        friends.stream().forEach(System.out::println);
    }

    @Test
    public void update() {
        Friend friend = repository.findById(5).get();
        friend.setFname("다인");
        friend.setFage(27);
        System.out.println(friend);
    }

    @Test
    public void delete() {
        Friend friend = repository.findById(5).get();
        repository.delete(friend);
    }
}
