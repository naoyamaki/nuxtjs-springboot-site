package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ItemController {

	@GetMapping("/item/")
	public String getAllItems() {
		String items = "{'item': [{'id': '1','name': 'アイテム1','categoryId': 2,'tagId': [3]},{'id': '2','name': 'アイテム2','categoryId': 2,'tagId': [3,4,8]},{'id': '3','name': 'アイテム3','categoryId': 5,'tagId': [2,6,9]}]}";
		return items;
	}

	@GetMapping("/item/{id}")
	public String searchItemById(@PathVariable("id") int id) {
		String item = "{'id': '"+id+"','name': 'アイテム2','categoryId': 2,'tagId': [3,4,8]}";
		return item;
	}
}