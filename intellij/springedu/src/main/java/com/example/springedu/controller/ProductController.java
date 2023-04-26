  package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.springedu.domain.ProductDTO;

@Controller
@SessionAttributes("p")
public class ProductController {
	@ModelAttribute("p")
	public ProductDTO create() {
		return new ProductDTO();
	}
	@GetMapping("/cart")
	public String productCart(@ModelAttribute("p") ProductDTO pdto) {
		return  "productView";
	}
	@GetMapping("/buy")
	public String clearCart(SessionStatus session) {	
		session.setComplete();
		return  "productView";
	}
}




