package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController {
    @PostMapping("/educontroller")
    public String edu(@RequestParam(value = "name", defaultValue = "입력없음") String name,
                        @RequestParam(value = "avgScore", defaultValue = "0") int avgScore){
        String score;
        if(avgScore >= 90) {
            score = "A";
        } else if (avgScore >= 80) {
            score = "B";
        } else if (avgScore >= 70) {
            score = "C";
        }else {
            score = "D";
        }
        return "grade" + score;
    }
}
