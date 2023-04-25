package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springedu.domain.StepVO;

@Controller
public class StepController {		
	@PostMapping("/step")
	public String memberHandle(@ModelAttribute("kkk") StepVO vo) {
		// 나이제한
		if(vo.getAge() < 18)
			return "redirect:/stepForm.html";
		System.out.println("[ 전달된 Command 객체의 정보 ]");
		System.out.println(vo.getName());
		System.out.println(vo.getPhoneNumber());
		System.out.println(vo.getAge());
		return  "stepOutput";
	}
}
