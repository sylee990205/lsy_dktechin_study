package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
@Controller
public class StaticController {	
	public StaticController() {
		System.out.println("HelloController Create object");
	}
	@RequestMapping("/static")
	public ModelAndView xxx(){
		InternalResourceView view = new InternalResourceView("/staticview.html");
		// InternalResourceView 객체로 staticview.html이라는 뷰 객체를 직접 만들어 return
		// 정적 자원 중에는 이미지가 포함될 수 있음
		ModelAndView viewModel = new ModelAndView(view);
		return viewModel;
	}	
}




