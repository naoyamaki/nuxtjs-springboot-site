package com.example.presentation.controller;

import com.example.usecase.SearchUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private SearchUserUseCase searchUserUseCase;

	@GetMapping("/user/")
	public String getAllUsers() {
		String users = "{'user': [{'id': '1','lastName': 'テスト','firstName': '太郎','roleId': 2,'groupId': 3},{'id': '2','lastName': 'テスト','firstName': '太郎2','roleId': 3,'groupId': 3},{'id': '3','lastName': 'テスト','firstName': '太郎3','roleId': 3,'groupId': 5}]}";
		return users;
	}

	@GetMapping("/user/{userId}/")
	public String searchUserById(@PathVariable("userId") Integer userId) {
		return searchUserUseCase.searchUserById(userId);
	}
}