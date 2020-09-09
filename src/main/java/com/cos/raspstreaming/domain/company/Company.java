package com.cos.raspstreaming.domain.company;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cos.raspstreaming.domain.BaseTimeEntity;
import com.cos.raspstreaming.domain.room.Room;
import com.cos.raspstreaming.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String phone;
	
	@JsonIgnoreProperties({"company"})
	@OneToMany(mappedBy = "company")
	private List<User> users;
	
	@OneToMany(mappedBy = "company")
	private List<Room> rooms;
}





