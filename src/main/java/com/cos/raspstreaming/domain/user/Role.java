package com.cos.raspstreaming.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // final 필드의 setter를 자동으로 만들어준다.
public enum Role {
	USER("ROLE_USER", "일반사용자"), MANAGER("ROLE_MANAGER", "매니저"), ADMIN("ROLE_ADMIN", "관리자");
	
	private final String key; // ROLE_USER
	private final String title; // 일반사용자
}
