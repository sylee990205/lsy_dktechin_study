package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.springedu.domain.CountDTO;
@Controller 
@SessionAttributes({"count1", "count2"})
public class CountController {
	@ModelAttribute("count1")
	public CountDTO countMethod1() {
		System.out.println("countMethod1 호출");
		return new CountDTO();
	}
	@ModelAttribute("count2")
	public CountDTO countMethod2() {
		System.out.println("countMethod2 호출");		
		return new CountDTO();
	}	
	@RequestMapping(value="/count") 
	public void handle(@ModelAttribute("count1") CountDTO vo1,
					   @ModelAttribute("count2") CountDTO vo2, int num1, int num2) {
		vo1.setCountNum(num1);
		vo2.setCountNum(num2);
		System.out.println("handle() : "+ 
			      vo1.getCountNum() + " : " + vo2.getCountNum());
		System.out.println("=============================");
	}
	@RequestMapping(value="/countdel")
	public void handle(SessionStatus s) { //return 값이 void일 때는 RequestMapping의 URL로 뷰를 보여줌
		//SessionStatus는 @SessionAttributes를 설정한 클래스 내에서만 사용 가능
		s.setComplete(); // session 속성을 제거하는 이벤트, 모든 세션 객체가 삭제됨. 원하는 것만 선택해서 삭제할 순 없음
		System.out.println("Both count1 and count2 deleted!");	
		System.out.println("=============================");
	}	
}



