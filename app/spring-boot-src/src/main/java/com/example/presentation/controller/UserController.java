package com.example.presentation.controller;

import com.example.usecase.SearchUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private SearchUserUseCase searchUserUseCase;

	@GetMapping("/")
	public String getAllUsers(@RequestParam(name="p",required=false,defaultValue = "1") Integer pageNum) {
		return searchUserUseCase.getAllUsers(pageNum);
	}

	@GetMapping("/{userId}/")
	public String searchUserById(@PathVariable("userId") Integer userId) {
		return searchUserUseCase.searchUserById(userId);
	}
}