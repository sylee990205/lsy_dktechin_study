package com.example.springedu.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springedu.domain.TestVO;
@RestController
public class JsonResponseController {
	@RequestMapping(value = "/getJSON1", produces = "application/json; charset=utf-8")
	public String test1(String id) {
		// 문자열 형식으로 만드는 방법 -> 귀찮음 효율성 제일 낮음
		String s = "{ \"name\":\"둘리\",\"id\":\"" + id +"\"}";
		return s;
	}

	@RequestMapping(value = "/getJSON2", produces = "application/json; charset=utf-8")
	public HashMap<String, String> test2(String id) {
		// HashMap을 사용하여 만드는 형식
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "유니코");
		map.put("id", id);
		return map;
	}
	
	@RequestMapping(value = "/getJSON3", produces = "application/json; charset=utf-8")
	public TestVO test3(String id) {
		//VO 객체를 만들어서 전달하는 형식
		TestVO vo = new TestVO();
		vo.setName("올라프");
		vo.setId(id);
		return vo;
	}
}
