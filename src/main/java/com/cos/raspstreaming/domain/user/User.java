package com.cos.raspstreaming.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cos.raspstreaming.domain.BaseTimeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)	
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String companyName;
	
	@Column(nullable = false)
	private String phone;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	// 더티체킹
	public void update(String password, String companyName, String phone) {
		this.password = password;
		this.companyName = companyName;
		this.phone = phone;
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}
	
}
