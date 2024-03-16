package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.service.BookListService;
import com.bookstore.service.BookService;

@Controller
public class MainController {
	
	@Autowired
	BookService bookservice;
	
	@Autowired
	BookListService bookListService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/registerbook")
	public String registerBook() {
		return "registerbook";
	}
	
	@GetMapping("/availablebooks")
	public ModelAndView availableBooks() {
		List<Book> list = bookservice.availableBooks();
		return new ModelAndView("availablebooks","book",list);
	}
	
	@GetMapping("/mybooks")
	public String myBooks(Model  model) {
		List<MyBookList>list=bookListService.getAllMyBooks();
		model.addAttribute("book",list);
		return "mybooks";
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookservice.addBook(b);
		return "redirect:/availablebooks";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = bookservice.getBookById(id);
		MyBookList myBookList = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		bookListService.getBookList(myBookList);
		return "redirect:/mybooks";
	}
	
	@RequestMapping("/deleteById/{id}")
	public String deleteByList(@PathVariable("id") int id) {
		bookservice.deleteById(id);
		bookListService.deleteById(id);
		return "redirect:/availablebooks";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = bookservice.getBookById(id);
		model.addAttribute("book", b);
		return "editbook";
	}
		
}
