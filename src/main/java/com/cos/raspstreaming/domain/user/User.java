package com.cos.raspstreaming.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.cos.raspstreaming.domain.BaseTimeEntity;
import com.cos.raspstreaming.domain.company.Company;

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
	
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;
	
	@Column(nullable = false)
	private String phone;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	@Transient // DTO 만들기 싫어서 사용
	private long companyId; 
	
	public String getRoleKey() {
		return this.role.getKey();
	}
	
}
