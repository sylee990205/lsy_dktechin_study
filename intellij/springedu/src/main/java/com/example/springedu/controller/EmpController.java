package com.example.springedu.controller;

import java.util.List;

import com.example.springedu.dao.EmpMapperDAO;
import com.example.springedu.domain.EmpVO;
import com.example.springedu.domain.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springedu.dao.EmpMybatisDAO;

@Controller
public class EmpController {
	/*	@Autowired
        EmpMybatisDAO dao;*/
	@Autowired
	EmpMapperDAO dao;

	@GetMapping("/countnum") // 수정
	public ModelAndView count() {
		ModelAndView mav = new ModelAndView();
		int num = dao.getAllDataNum();
		mav.addObject("num", num);
		mav.setViewName("empResult");
		return mav;
	}

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<EmpVO> list = dao.listAll();
		mav.addObject("list", list);
		mav.setViewName("empResult");
		return mav;
	}

	@GetMapping("/part")
	public ModelAndView part(PageDTO vo) {
		ModelAndView mav = new ModelAndView();
		List<EmpVO> list = dao.listPart(vo);
		mav.addObject("list", list);
		mav.setViewName("empResult");
		return mav;
	}

}
