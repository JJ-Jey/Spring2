package com.green.nowon.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyUserController {
	
	private final MyUserService service;
	
	@PostMapping("/user")
	public String signup(MyUserRequestDTO dto) {
		service.saveProcess(dto);
		return "redirect:/login";
	}

}
