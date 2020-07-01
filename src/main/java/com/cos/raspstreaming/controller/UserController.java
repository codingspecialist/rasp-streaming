package com.cos.raspstreaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.raspstreaming.domain.user.User;
import com.cos.raspstreaming.service.UserService;
import com.cos.raspstreaming.util.Script;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/auth/joinProc")
	public @ResponseBody String joinProc(User user) {
//		System.out.println("username : "+user.getUsername());
//		System.out.println("password : "+user.getPassword());
//		System.out.println("companyName : "+user.getCompanyName());
//		System.out.println("phone : "+user.getPhone());
		
		userService.회원가입(user);
		return Script.href("회원가입성공", "/auth/loginForm");
	}
}
