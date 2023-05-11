package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class QueryStringController1 {
	@RequestMapping("/querystring1")
	public ModelAndView proc(String name) {
		// name이라는 이름으로 쿼리문자열을 추출하여 처리
		// 매개변수가 오지 않을 때는 null 로 처리되어 String 타입은 error가 발생하지않음
		// 숫자일땐 null을 숫자로 변환하는 과정에서 error 발생
		ModelAndView mav = new ModelAndView();
		// ModelAndView 모델정보와 뷰 정보가 모두 들어가는 객체
		System.out.println("["+name+"]");
		mav.addObject("spring", name);
		// Spring이라는 이름으로 name을 전달함
		mav.setViewName("queryView1");
		// 확장자와 파일 경로를 제외하고 html 파일 명만 view name으로 설정
		return mav;
	}	
	@RequestMapping("/querystring2")
	public ModelAndView proc(int number) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", number);
		mav.setViewName("queryView1");
		return mav;
	}	
	@RequestMapping("/querystring3")
	public ModelAndView proc(String name, 
			                   @RequestParam("num")int number) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", name+":"+number);
		mav.setViewName("queryView1");
		return mav;
	}
	@RequestMapping("/querystring4")
	public ModelAndView proc(
	@RequestParam("myname1") String name1, //RequestParam으로 이름을 지정했으면 반드시 줘야함
	@RequestParam(value="myname2", required=false) String name2,
	@RequestParam(defaultValue="10") int number1, 
	@RequestParam(value="NUM2", defaultValue="100")int number2){
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", name1+":"+(number1 + number2) 
				+":"+name2);
		mav.setViewName("queryView1");
		return mav;
	}
}






