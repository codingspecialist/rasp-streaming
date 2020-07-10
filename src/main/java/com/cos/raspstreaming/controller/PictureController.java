package com.cos.raspstreaming.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PictureController {

	@GetMapping("/picture/uploadForm")
	public String uploadForm() {
		return "picture/uploadForm";
	}
	
	@PostMapping("/picture/uploadProc")
	public @ResponseBody String uploadProc(@RequestParam List<MultipartFile> files) throws Exception{
		List<String> list = new ArrayList<>();
		for (MultipartFile file : files) {
			String originalfileName = file.getOriginalFilename();
			System.out.println(originalfileName);
			File dest = new File("C:/Image/" + originalfileName);
			file.transferTo(dest);
		}
		return "사진 전송 성공";
	}
}
