package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.springedu.domain.MemberDTO;

@Controller
public class MemberController {	
	
	@PostMapping("/member1")
	protected ModelAndView proc1(@RequestParam(value = "name", defaultValue = "없음") String name,
			@RequestParam(value = "phone", defaultValue = "없음") String phone,
			@RequestParam(value = "id", defaultValue = "없음") String id,			
			@RequestParam(value = "password", defaultValue = "없음") String password) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("id", id);
		mav.addObject("phone", phone);
		mav.addObject("password", password);
		mav.setViewName("memberView");
		return mav;
	}
	
	@PostMapping("/member2")
	public String proc2(@ModelAttribute("member") MemberDTO dto) {
		//매개변수로 컨멘드 객체를 주면 request 객체를 첫글자를 소문자로 바꿔서 알아서 지정함
		//@ModelAttribute를 사용하면 member라는 이름으로 변경 가능
		if( dto.getName() == null || dto.getName().equals(""))
			dto.setName("없음");
		if( dto.getPhone() == null || dto.getPhone().equals(""))
			dto.setPhone("없음");
		if( dto.getId() == null || dto.getId().equals(""))
			dto.setId("없음");
		if( dto.getPassword() == null || dto.getPassword().equals(""))
			dto.setPassword("없음");
		return "memberView";
	}
	
	@PostMapping("/member3")
	public String proc3(MemberDTO dto) { // memberDTO 이름으로 request 객체에 보관까지 된다
		if( dto.getName() == null || dto.getName().equals(""))
			dto.setName("없음");
		if( dto.getPhone() == null || dto.getPhone().equals(""))
			dto.setPhone("없음");
		if( dto.getId() == null || dto.getId().equals(""))
			dto.setId("없음");
		if( dto.getPassword() == null || dto.getPassword().equals(""))
			dto.setPassword("없음");
		
		return "memberView";
	}
}
