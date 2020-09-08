package com.cos.raspstreaming.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.raspstreaming.domain.company.Company;
import com.cos.raspstreaming.domain.company.CompanyRepository;
import com.cos.raspstreaming.domain.user.User;
import com.cos.raspstreaming.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminService {
	
	private final UserRepository userRepository;
	private final CompanyRepository companyRepository;
	
	@Transactional(readOnly = true)
	public Page<User> 회원관리(Pageable pageable){
		return userRepository.findAll(pageable);
	}
	
	@Transactional
	public void 회사등록(Company company){
		companyRepository.save(company);
	}
	
	@Transactional(readOnly = true)
	public Page<Company> 회사관리(Pageable pageable){
		return companyRepository.findAll(pageable);
	}
}
