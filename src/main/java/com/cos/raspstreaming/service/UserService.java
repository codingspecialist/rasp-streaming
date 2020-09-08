package com.cos.raspstreaming.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.raspstreaming.domain.company.Company;
import com.cos.raspstreaming.domain.company.CompanyRepository;
import com.cos.raspstreaming.domain.user.Role;
import com.cos.raspstreaming.domain.user.User;
import com.cos.raspstreaming.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final CompanyRepository companyRepository;
	private final PasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public List<Company> 회사목록(){
		return companyRepository.findAll();
	}
	
	@Transactional
	public void 회원가입(User user) {
		Company companyEntity = companyRepository.findById(user.getCompanyId()).orElseGet(new Supplier<Company>() {
			@Override
			public Company get() {
				return null;
			}
		});
		user.setRole(Role.USER);
		user.setPassword(encoder.encode(user.getPassword()));
		if(companyEntity != null) user.setCompany(companyEntity);
		userRepository.save(user);
	}
	
	@Transactional
	public void 회원수정() {
		
	}
	
	@Transactional
	public void 회원탈퇴() {
		
	}
}
