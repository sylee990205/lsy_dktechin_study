package com.example.springedu3.service;

import com.example.springedu3.entity.Friend;
import com.example.springedu3.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// 통합 클래스 이름 Dao + Service
@Service
public class FriendDaoService {
    @Autowired
    FriendRepository repo;
    // 모든 유저 리스트 반환
    public List<Friend> friendList(){
        return repo.findAll();
    }
}