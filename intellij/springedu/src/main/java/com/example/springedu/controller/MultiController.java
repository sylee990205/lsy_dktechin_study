package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MultiController {	
	@RequestMapping(value="/select")
	public String select_proc() {
		// 매개변수에 주목해야함 select와 search는 매개변수 x -> 그냥 요청해도됨
		System.out.println("select ............");
		return  "viewTest";
	}
	@RequestMapping(value="/search")
	public String search_proc() {
		System.out.println("search ............");
		return "viewTest";
	}
	@RequestMapping(value="/insert")
	public String insert_proc(int pageno) {
		// 매개변수 o -> 매개변수에 따라 쿼리문자열을 줘야할수도있고 아닐수도 있음
		// 매개변수가 있다는것은 쿼리문자열을 받겠다는 의미
		// int로 지정한것 쿼리문자열을 숫자로 받겠다는 것
		// 스프링에서는 매개변수만 잘 선언하면 메서드가 호출될 때 쿼리문자열을 알아서 전달함 -> DispatcherServlet이 하는 역할
		System.out.println("insert ............"+pageno);
		return  "viewTest";
	}
	@RequestMapping(value="/viewTest")
	public void void_proc(int pageno) {
		System.out.println("viewTest ............");
	}	
}


