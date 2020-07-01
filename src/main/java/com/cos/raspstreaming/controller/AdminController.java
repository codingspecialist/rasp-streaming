package com.cos.raspstreaming.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.raspstreaming.service.AdminService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AdminController {
	
	private final AdminService adminService;
	
	@GetMapping("/admin")
	public String user(Model model, @PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("users", adminService.회원관리(pageable));
		return "/admin/userManage";
	}
}
