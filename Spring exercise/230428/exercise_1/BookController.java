package com.example.springedu.controller;

import com.example.springedu.dao.BookMybatisDAO;
import com.example.springedu.domain.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller()
public class BookController {
    @Autowired
    BookMybatisDAO dao;

    @RequestMapping("/book")
    public String bookPage() {
        return "bookPage";
    }

    @RequestMapping(value = "/bookinfo/{button}")
    public ModelAndView getBookInfo(@PathVariable String button) {
        ModelAndView mav = new ModelAndView();
        List<BookDTO> list = null;
        switch (button) {
            case "b1":
                System.out.printf("하하");
                list = dao.b1();
                break;
            case "b2":
                list = dao.b2();
                break;
            case "b3":
                list = dao.b3();
                break;
            case "b4":
                list = dao.b4();
                break;
            case "b5":
                list = dao.b5();
                break;
            case "b6":
                list = dao.b6();
                break;
            case "b7":
                list = dao.b7();
                break;
            case "b8":
                list = dao.b8();
                break;
        }
        if (list.size() != 0) {
            mav.addObject("list", list);
        } else {
            mav.addObject("msg", "추출된 데이터가 없네용");
        }
        mav.setViewName("bookPage");
        return mav;
    }

    @GetMapping("/bookCreate")
    public String getInsert(BookDTO dto) {
        return "bookCreatePage";
    }

    @PostMapping("/bookCreate")
    public ModelAndView postInsert(BookDTO dto){
        ModelAndView mav = new ModelAndView();
        boolean result = dao.insert(dto);
        if(result){
            mav.addObject("book", dto);
        }
        else {
            mav.addObject("msg", "데이터를 입력하는 과정에서 오류 발생");
        }
        mav.setViewName("bookCreatePage");
        return mav;
    }
}
