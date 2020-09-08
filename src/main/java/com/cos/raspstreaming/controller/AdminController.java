package com.cos.raspstreaming.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.raspstreaming.domain.company.Company;
import com.cos.raspstreaming.service.AdminService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AdminController {
	
	private final AdminService adminService;
	
	// 회원관리 페이지
	@GetMapping("/admin/user")
	public String user(Model model, @PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("users", adminService.회원관리(pageable));
		return "/admin/user/manage";
	}
	
	// 회사등록 페이지
	@GetMapping("/admin/company/saveForm")
	public String companySaveForm() {
		return "/admin/company/saveForm";
	}
	
	// 회사등록
	@PostMapping("/admin/company")
	public String companySave(Company company) {
		adminService.회사등록(company);
		return "redirect:/admin/company";
	}
	
	// 회사관리
	@GetMapping("/admin/company")
	public String companySave(Model model, @PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("companys", adminService.회사관리(pageable));
		return "/admin/company/manage";
	}
}
