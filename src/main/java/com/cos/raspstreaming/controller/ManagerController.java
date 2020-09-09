package com.cos.raspstreaming.controller;

import java.io.File;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cos.raspstreaming.config.PathValue;
import com.cos.raspstreaming.config.auth.PrincipalDetail;
import com.cos.raspstreaming.domain.company.Company;
import com.cos.raspstreaming.domain.funeral.Funeral;
import com.cos.raspstreaming.domain.room.Room;
import com.cos.raspstreaming.service.ManagerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ManagerController {

	private final ManagerService managerService;
	
	@GetMapping("/manager/room/saveForm")
	public String roomSaveForm() {
		return "/manager/room/saveForm";
	}
	
	@GetMapping("/manager/picture/saveForm")
	public String pictureSaveForm() {
		return "/manager/picture/saveForm";
	}
	
	@GetMapping("/manager/video/saveForm")
	public String videoSaveForm() {
		return "/manager/video/saveForm";
	}
	
	@GetMapping("/manager/funeral/saveForm")
	public String funeralSaveForm() {
		return "/manager/funeral/saveForm";
	}
	
	@GetMapping("/test/manager/funeral/saveForm")
	public @ResponseBody List<Room> testFuneralSaveForm(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
		// 비활성 호실 모두 가져오기
		long userId = principalDetail.getUser().getId();
		 
		return null;
	}
	
	@GetMapping("/manager/room")
	public String roomManage(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model, 
			@PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		long companyId = principalDetail.getUser().getCompany().getId();
		model.addAttribute("rooms", managerService.호실관리(companyId, pageable));
		return "/manager/room/manage";
	}
	
	@GetMapping("/test/manager/room")
	public @ResponseBody Page<Room> testRoomManage(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model, 
			@PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		long companyId = principalDetail.getUser().getCompany().getId();	
		return managerService.호실관리(companyId, pageable);
	}
	
	@PostMapping("/manager/picture")
	public @ResponseBody String uploadProc(@RequestParam List<MultipartFile> files) throws Exception{
		for (MultipartFile file : files) {
			String originalfileName = file.getOriginalFilename();
			System.out.println(originalfileName);
			File dest = new File(PathValue.IMAGE_PATH  + originalfileName);
			file.transferTo(dest);
		}
		return "사진 전송 성공"; // 수정필요
	}
	
	@PostMapping("/manager/room")
	public String roomSave(int roomNum, @AuthenticationPrincipal PrincipalDetail principalDetail) {
		Company company = principalDetail.getUser().getCompany();
		managerService.호실등록(roomNum, company);
		return "redirect:/manager/room";
	}
	
	@PostMapping("/manager/funeral")
	public String funeralSave(Funeral funeral, @AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
		System.out.println("funeral : "+funeral);
		return "/manager/funeral/saveForm";
	}

}
