package com.cos.raspstreaming.controller.api;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.raspstreaming.config.auth.PrincipalDetail;
import com.cos.raspstreaming.domain.room.Room;
import com.cos.raspstreaming.domain.room.RoomRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ApiController {
	
	private final RoomRepository roomRepository;
	
	@GetMapping("/activeRooms")
	public List<Room> testFuneralSaveForm(@AuthenticationPrincipal PrincipalDetail principalDetail, String startDate) {
		long companyId = principalDetail.getUser().getCompany().getId();
		 
		List<Room> rooms = roomRepository.mFindActiveRooms(startDate, companyId);
		
		return rooms;
	}
}



