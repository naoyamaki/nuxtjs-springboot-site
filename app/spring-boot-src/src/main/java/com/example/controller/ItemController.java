package com.example.controller;

import com.example.jooq.tables.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import org.jooq.*;
import org.jooq.impl.*;
import static com.example.jooq.tables.User.USER;
import static org.jooq.impl.DSL.*;


@RestController
@RequestMapping("/api")
public class ItemController {

	@GetMapping("/item/")
	public String getAllItems() {
		String userName = "root";
		String password = "#sample1234";
		String url = "jdbc:mysql://db:3306/main";

		String csv = "初期値";
		try (Connection conn = DriverManager.getConnection(url, userName, password)) {
			DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
			csv = create.select().from(USER).fetch().formatCSV();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return csv;
	}

	@GetMapping("/item/{id}")
	public String searchItemById(@PathVariable("id") int id) {
		String item = "{'id': '"+id+"','name': 'アイテム2','categoryId': 2,'tagId': [3,4,8]}";
		return item;
	}
}