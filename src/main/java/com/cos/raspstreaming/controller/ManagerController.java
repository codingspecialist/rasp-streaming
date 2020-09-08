package com.cos.raspstreaming.controller;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cos.raspstreaming.config.PathValue;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ManagerController {

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
	

}
