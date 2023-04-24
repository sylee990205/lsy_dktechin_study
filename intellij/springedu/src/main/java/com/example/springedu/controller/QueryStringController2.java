package com.example.springedu.controller;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springedu.domain.QueryDTO;
@Controller
public class QueryStringController2 {	
	@RequestMapping("/querystring5")
	public ModelAndView proc(QueryDTO vo) {  // 컨멘드 객체
		ModelAndView mav = new ModelAndView();
		String name = vo.getTestName();
		int age = vo.getTestAge();
		String addr = vo.getTestAddr();
		mav.addObject("spring", name + "-" + age + "-" + addr);
		mav.setViewName("queryView2");
		return mav;
	}	
	@RequestMapping(value = "/querystring6", 
			                      method = RequestMethod.POST)
	// POST 방식으로 요청했을 때만 가능
	public ModelAndView procPost(QueryDTO vo) {
		ModelAndView mav = new ModelAndView();
		String name = vo.getTestName();
		int age = vo.getTestAge();
		String addr = vo.getTestAddr();
		mav.addObject("spring", name + "@" + age + "@" + addr);
		mav.setViewName("queryView2");
		return mav;
	}
	@RequestMapping("/querystring7")
	public ModelAndView proc(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String name =request.getParameter("testName");
		int age = Integer.parseInt(request.getParameter("testAge"));
		String addr = request.getParameter("testAddr");
		mav.addObject("spring", name + "#" + age + "#" + addr);
		mav.setViewName("queryView2");
		return mav;
	}
	@RequestMapping(value="/locale/mine")
	public ModelAndView proc(Locale l) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", "Processing locale ............"+
		       l.getDisplayCountry()+"_"+l.getDisplayLanguage());
		mav.setViewName("queryView2");
		return mav;
	}
}






