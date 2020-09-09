package com.cos.raspstreaming.domain.room;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cos.raspstreaming.domain.BaseTimeEntity;
import com.cos.raspstreaming.domain.company.Company;
import com.cos.raspstreaming.domain.funeral.Funeral;
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
public class Room extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int roomNum;
	 
	@JsonIgnoreProperties({"rooms"})
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;
	
	@JsonIgnoreProperties({"room", "company"})
	@OneToMany(mappedBy = "room") // 이걸로 해당룸에 연결되 있는 활성화(useState)된 장례식을 한개 찾기
	private List<Funeral> funerals;
	
}
