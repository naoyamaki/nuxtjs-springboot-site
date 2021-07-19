package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

	@GetMapping("/search/{num}/")
	public String search(@PathVariable("num") String num) {
		return num+" test";
	}
}