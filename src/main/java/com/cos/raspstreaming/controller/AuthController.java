package com.cos.raspstreaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.raspstreaming.domain.user.User;
import com.cos.raspstreaming.service.UserService;
import com.cos.raspstreaming.util.Script;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {
	
	private final UserService userService;
	
	@GetMapping({"", "/"})
	public String index() {
		return "index";
	}
	
	@PostMapping("/auth/join")
	public @ResponseBody String joinProc(User user) {
		System.out.println("user : "+user);
		userService.회원가입(user);
		return Script.href("회원가입성공", "/auth/loginForm");
	}
	
	@GetMapping("/auth/joinForm")
	public String joinForm(Model model) {
		model.addAttribute("companys", userService.회사목록());
		return "auth/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "auth/loginForm";
	}
}
