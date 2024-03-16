package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.service.BookListService;

@Controller
public class MyBookListController {
	
	@Autowired
	BookListService bookListService;
	
	@RequestMapping("/deleteByList/{id}")
	public String deleteByList(@PathVariable("id") int id) {
		bookListService.deleteById(id);
		return "redirect:/mybooks";
	}
}
