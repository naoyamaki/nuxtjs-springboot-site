package com.example.restservice;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.SearchParams;

@RestController
public class SearchController {

	@RequestMapping("/search/{num}/")
	@ResponseBody
	public String search(@PathVariable("num") String num) {
		return num*100;
	}
}