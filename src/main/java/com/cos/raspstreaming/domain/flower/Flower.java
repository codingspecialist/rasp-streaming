package com.cos.raspstreaming.domain.flower;

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
import com.cos.raspstreaming.domain.picture.Picture;
import com.cos.raspstreaming.domain.video.Video;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flower extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String customerName; // 화환신청한 고객명
	private String customerPhone; // 화환신청한 고객전화번호
	
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="funeralId")
	private Funeral funeral; // 화환 입력시에 어떤 장례식에서 하는지만 알면 됨.
	
	@OneToMany(mappedBy = "flower")
	private List<Picture> pictures;
	
	@OneToMany(mappedBy = "flower")
	private List<Video> videos;
}
