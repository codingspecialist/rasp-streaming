package com.cos.raspstreaming.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.raspstreaming.domain.company.Company;
import com.cos.raspstreaming.domain.room.Room;
import com.cos.raspstreaming.domain.room.RoomRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ManagerService {

	private final RoomRepository roomRepository;
	
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
	

}
