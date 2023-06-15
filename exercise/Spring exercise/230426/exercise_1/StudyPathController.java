package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudyPathController {
    @RequestMapping(value = "/study/{number}/thymeleaf")
    public String studyPathMove(@PathVariable int number){
        switch (number){
            case 1:
                return "redirect:https://abbo.tistory.com/56";
            case 2:
                return "redirect:https://abbo.tistory.com/57";
            case 3:
                return "redirect:https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html";
            case 4:
                return "redirect:https://www.baeldung.com/dates-in-thymeleaf";
            default:
                return "redirect:https://em-content.zobj.net/thumbs/120/apple/354/cross-mark_274c.png";
        }
    }
}
