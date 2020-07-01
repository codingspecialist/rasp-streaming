package com.cos.raspstreaming.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.raspstreaming.domain.user.Role;
import com.cos.raspstreaming.domain.user.User;
import com.cos.raspstreaming.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	
	@Transactional
	public void 회원가입(User user) {
		user.setRole(Role.GUEST);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	@Transactional
	public void 회원인증() {
		
	}
	
	@Transactional
	public void 회원수정() {
		
	}
	
	@Transactional
	public void 회원탈퇴() {
		
	}
}
