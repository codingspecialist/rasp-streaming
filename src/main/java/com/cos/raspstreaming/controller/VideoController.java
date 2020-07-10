package com.cos.raspstreaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoController {

	@GetMapping("/video/uploadForm")
	public String uploadForm() {
		return "video/uploadForm";
	}
}