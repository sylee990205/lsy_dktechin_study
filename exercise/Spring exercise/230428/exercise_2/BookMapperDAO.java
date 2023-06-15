package com.example.springedu.dao;

import com.example.springedu.domain.BookDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapperDAO {
    @Select("select * from book")
    public List<BookDTO> b1();

    @Select("select * from book order by price desc")
    public List<BookDTO> b2();

    @Select("select title, price from book where price >= 20000")
    public List<BookDTO> b3();

    @Select("select title, price from book where kind LIKE '%2'")
    public List<BookDTO> b4();

    @Select("select title, price from book where kind LIKE '%4' || kind LIKE '%5'")
    public List<BookDTO> b5();

    @Select("select title, price from book where title LIKE concat('%', #{word} , '%')")
    public List<BookDTO> b6(String word);

    @Select("select title, price from book where title LIKE concat('%', #{word} , '%')")
    public List<BookDTO> b7(String word);

    @Select("select kind, avg(price) price from book group by kind")
    public List<BookDTO> b8();

    @Insert("insert into book(title, price, kind) values (#{title}, #{price}, #{kind})")
    public boolean insert(BookDTO dto);
}
