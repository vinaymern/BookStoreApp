package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.MyBookList;
import com.bookstore.repository.BookListRepository;

@Service
public class BookListService {
	
	@Autowired
	BookListRepository bookListRepository;
	
	public void getBookList(MyBookList bookList) {
		bookListRepository.save(bookList);
	}
	
	public List<MyBookList>getAllMyBooks(){
		return bookListRepository.findAll();
	}
	
	public void deleteById(int id) {
		bookListRepository.deleteById(id);
	}
}
