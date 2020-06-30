package com.cos.raspstreaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping({"", "/"})
	public String index() {
		System.out.println("나 실행돼?");
		return "index";
	}
}
