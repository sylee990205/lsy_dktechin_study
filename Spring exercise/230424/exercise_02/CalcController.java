package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {
    @GetMapping("/calc.do")
    public ModelAndView calc(int firstNum, int secondNum, String operator){
        ModelAndView mav = new ModelAndView();

        if(operator.equals("plus")){
            mav.addObject("result", firstNum + secondNum);
        } else if (operator.equals("minus")) {
            mav.addObject("result", firstNum - secondNum);
        } else if (operator.equals("multiply")) {
            mav.addObject("result", firstNum * secondNum);
        } else if (operator.equals("divide")) {
            if(secondNum == 0){
                mav.addObject("msg", "나눗셈 연산 시 두 번째 숫자는 0일 수 없습니다!!!");
                mav.setViewName("errorResult");
                return mav;
            } else {
                mav.addObject("result", firstNum / secondNum);
            }
        }
        mav.setViewName("calcResult");
        return mav;
    }
}
