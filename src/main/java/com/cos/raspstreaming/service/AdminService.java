package com.cos.raspstreaming.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cos.raspstreaming.domain.user.User;
import com.cos.raspstreaming.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminService {
	
	private final UserRepository userRepository;
	
	public Page<User> 회원관리(Pageable pageable){
		return userRepository.findAll(pageable);
	}
}
