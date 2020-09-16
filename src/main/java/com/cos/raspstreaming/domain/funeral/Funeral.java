package com.cos.raspstreaming.domain.funeral;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.cos.raspstreaming.domain.BaseTimeEntity;
import com.cos.raspstreaming.domain.company.Company;
import com.cos.raspstreaming.domain.room.Room;
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
public class Funeral extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String customerName; // 장례신청한 고객명
	private String customerPhone; // 장례신청한 고객전화번호
	
	@JsonIgnoreProperties({"users", "rooms"})
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company; // 로그인한 매니저 아이디로 넣기
	
	@JsonIgnoreProperties({"company", "funerals"})
	@ManyToOne // OneToOne이 맞음. 그런데 room 마다 하나의 장례식만 있기 때문. 그런데 데이터가 쌓이면 room마다 여러개의 장례식이 생길 수 있음. 활성화여부 필요(네이티브쿼리) 
	@JoinColumn(name = "roomId")
	private Room room; // 몇호실에 신청됐는지 넣기
	
	// 달력으로 입력받기
	private LocalDate startDate;
	private LocalDate endDate;
	
	private boolean useState; // 장례식 진행 여부(현재 활성화? 비활성화?) - 배치프로그램으로 새벽에 돌려서 업데이트하기(endDate로)
	
	@Transient
	private long roomId;
	
	public void setStartDate(String startDate) {
		this.startDate = LocalDate.parse(startDate);
	}
}
