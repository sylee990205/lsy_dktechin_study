package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestModelController2 {
	@ModelAttribute("data1")
	public int createModel1() {	
		System.out.println("createModel1() 호출");
		return 100;
	}
	@ModelAttribute("data2")
	public int createModel2() {	
		System.out.println("createModel2() 호출");
		return 200;
	}
	@RequestMapping(value="/modeltest2")
	//컨트롤러 메소드에서 커맨드 메소드 객체를 사용할 수 있음
	//@ModelAttribute가 아니었으면 vo1이라는 쿼리문자열로 클라이언트가 전달한 값이 들어가지만
	//보관시 사용한 이름 - @ModelAttribute로 지정한 이름으로 vo1의 값이 data1 객체로 처리
	public String handle(@ModelAttribute("data1") int vo1,
			      @ModelAttribute("data2") int vo2) {		
		System.out.println("handle 에서 출력 : "+vo1 + " - " + vo2);
		System.out.println("=============================");
		return "modelResult2";
	}	
}
