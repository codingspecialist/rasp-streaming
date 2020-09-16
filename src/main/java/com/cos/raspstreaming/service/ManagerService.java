package com.cos.raspstreaming.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.raspstreaming.domain.company.Company;
import com.cos.raspstreaming.domain.company.CompanyRepository;
import com.cos.raspstreaming.domain.funeral.Funeral;
import com.cos.raspstreaming.domain.funeral.FuneralRepository;
import com.cos.raspstreaming.domain.room.Room;
import com.cos.raspstreaming.domain.room.RoomRepository;
import com.cos.raspstreaming.domain.user.UserRepository;
import com.cos.raspstreaming.util.DateUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ManagerService {

	private final CompanyRepository companyRepository;
	private final UserRepository userRepository;
	private final RoomRepository roomRepository;
	private final FuneralRepository funeralRepository;
	
	@Transactional
	public void 호실등록(int roomNum, Company company) {
		Room room = Room.builder()
				.roomNum(roomNum)
				.company(company)
				.build();
		roomRepository.save(room);
	}
	
	@Transactional(readOnly = true)
	public Page<Room> 호실관리(long companyId, Pageable pageable){
		return roomRepository.findByCompanyId(companyId, pageable);
	}
	
	@Transactional
	public void 장례식등록(Funeral funeral, Company company) {
		funeral.setCompany(company);
		funeral.setUseState(false); // 오늘날짜이면 true, 그게 아니면 false, 밤00시 이후에 배치돌면서 true로 바뀜
		LocalDate endDate = DateUtils.getPlusLocalDate(funeral.getStartDate(), 2);
		funeral.setEndDate(endDate);
		
		Room roomEntity = roomRepository.findById(funeral.getRoomId()).orElseThrow(() -> {
			return new IllegalArgumentException("방 번호를 찾을 수 없습니다.") ;
		});
		funeral.setRoom(roomEntity);
		
		funeralRepository.save(funeral);
	}
	
	public Page<Funeral> 장례식관리(long companyId, Pageable pageable){
		return funeralRepository.findByCompanyId(companyId, pageable);
	}
}





