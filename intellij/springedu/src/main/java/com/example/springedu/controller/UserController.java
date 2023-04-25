package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springedu.domain.UserVO;

@Controller
public class UserController {

	@ModelAttribute("popularFruit")
	public String[] refPopularFruit() {
		System.out.println("popularFruit 명으로 보관될 문자열 배열객체 생성과 보관");
		return new String[] { "사과", "딸기", "청포도", "키위" };
	}

	@RequestMapping(value = "/userForm", method = RequestMethod.GET)
	public String userForm() {
		System.out.println("----- UserController.userForm() : GET -----");
		return "userForm";
	}

	@RequestMapping(value = "/userSave", method = RequestMethod.POST)
	public String userSave(UserVO userVo, Model model) {
		System.out.println("----- UserController.userSave() : POST -----");
		System.out.println("userInfo : " + userVo.toString());
		model.addAttribute("msg", "SUCCESS");
		// model, 뷰에게 전달할 데이터를 담을 객체
		return "userInfo";
	}
}
