package com.example.springedu.dao;

import com.example.springedu.domain.BookDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookMybatisDAO {
    @Autowired
    SqlSession session;

    public List<BookDTO> b1(){
        List<BookDTO> list = null;
        try {
            String statement = "lab1.exam1";
            list = session.selectList(statement);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<BookDTO> b2(){
        List<BookDTO> list = null;
        try {
            String statement = "lab1.exam2";
            list = session.selectList(statement);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<BookDTO> b3(){
        List<BookDTO> list = null;
        try {
            String statement = "lab1.exam3";
            list = session.selectList(statement);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<BookDTO> b4(){
        List<BookDTO> list = null;
        try {
            String statement = "lab1.exam4";
            list = session.selectList(statement);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<BookDTO> b5(){
        List<BookDTO> list = null;
        try {
            String statement = "lab1.exam5";
            list = session.selectList(statement);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<BookDTO> b6(){
        List<BookDTO> list = null;
        try {
            String statement = "lab1.exam6";
            list = session.selectList(statement, "자바");
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<BookDTO> b7(){
        List<BookDTO> list = null;
        try {
            String statement = "lab1.exam6";
            list = session.selectList(statement, "스프링");
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<BookDTO> b8(){
        List<BookDTO> list = null;
        try {
            String statement = "lab1.exam7";
            list = session.selectList(statement);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
