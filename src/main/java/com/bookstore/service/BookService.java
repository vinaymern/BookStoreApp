package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookService{
	
	@Autowired
	BookRepository bookRepo;
	
	public void addBook(Book b) {
		bookRepo.save(b);
	}
	
	public List<Book> availableBooks(){
		return bookRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		bookRepo.deleteById(id);
	}
	
}
