package com.example.springedu.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.springedu.domain.MyVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestModelController1 {
	@ModelAttribute("v1")
	// 컨트롤러 메소드 외 일반 메소드에도 적용할 수 있음
	// 단, 이 메소드가 모델을 return해주는 메소드여야함
	// ModelAttribute가 붙은 메소드를 handler 메소드 호출 전 먼저 호출하고
	// 각 메소드를 ModelAttribute에서 설정한 이름으로 request 객체에 저장함
	public String createString() {
		System.out.println("객체 생성 자동호출1");
		return "테스트!!";
	}
	@ModelAttribute("v2")
	public int[] createArray() {
		System.out.println("객체 생성 자동호출2");
		return new int[]{10, 20, 30, 40, 50};
	}
	@ModelAttribute("v3")
	public MyVO createVO() {
		System.out.println("객체 생성 자동호출3");
		MyVO vo = new MyVO( 23, "yellow");
		return vo;
	}	
	@ModelAttribute("v4")
	public Date createDate() {
		System.out.println("객체 생성 자동호출4");		
		return new Date();
	}	
	@ModelAttribute("v5")
	public List<MyVO> createList() {
		System.out.println("객체 생성 자동호출5");
		List<MyVO> list = new ArrayList<MyVO>();
		MyVO vo = new MyVO(7, "red");
		list.add(vo);
		vo = new MyVO(11, "pink");
		list.add(vo);
		return list;
	}	
	@RequestMapping("/modeltest1")
	// RequestMapping, GetMapping, PostMapping이 붙어있는 메소드만 컨트롤러 메소드임
	public String handle() {
		System.out.println("handle() 메서드 호출");		
		return "modelResult1";
	}
}



