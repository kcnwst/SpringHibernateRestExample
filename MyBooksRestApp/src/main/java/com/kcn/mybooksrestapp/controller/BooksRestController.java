package com.kcn.mybooksrestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kcn.mybooksrestapp.dao.BookDAO;
import com.kcn.mybooksrestapp.entity.Book;

@RestController
public class BooksRestController {

	@Autowired
	BookDAO bookdao;
	
	/**
	 * Http GET request for all books in database.
	 * 
	 * @return
	 */
	@GetMapping("/books")
	public List getCustomers() {
		
		return bookdao.getBooks();
	}
	
	/**
	 * Http GET request for a book with the isbn of the path variable.
	 * 
	 * @param isbn
	 * @return
	 */
	@GetMapping("/books/{isbn}")
	public ResponseEntity getCustomer(@PathVariable("isbn") String isbn) {
		
		Book book = bookdao.getBook(isbn);
		
		if(book == null) {
			return new ResponseEntity("No book found for isbn: " + isbn, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(book, HttpStatus.OK);
	}
	
	/**
	 * Http POST request for a book object.
	 * 
	 * @param book
	 * @return
	 */
	@PostMapping(value = "/books")
	public ResponseEntity createBook(@RequestBody Book book) {
		
		bookdao.saveBook(book);
		
		return new ResponseEntity(book, HttpStatus.OK);
	}
	
	/**
	 * Http DELETE request for a book with the isbn of the path variable.
	 * 
	 * @param isbn
	 * @return
	 */
	@DeleteMapping("/books/{isbn}")
	public ResponseEntity deleteBook(@PathVariable String isbn) {
		
		Book book = bookdao.getBook(isbn);
		
		if(book == null) {
			return new ResponseEntity("No book found for isbn: " + isbn, HttpStatus.NOT_FOUND);
		} else {
			bookdao.deleteBook(isbn);
		}
		
		return new ResponseEntity(isbn, HttpStatus.OK);
	}
	
	/**
	 * Http PUT request for a book object with the isbn of the path variable and replaced by the request body.
	 * 
	 * @param isbn
	 * @param book
	 * @return
	 */
	@PutMapping("/books/{isbn}")
	public ResponseEntity updateBook(@PathVariable String isbn, @RequestBody Book book) {
		
		Book b = bookdao.getBook(isbn);
		
		if(b == null) {
			return new ResponseEntity("No book found for isbn: " + isbn, HttpStatus.NOT_FOUND);
		} else {
			bookdao.updateBook(isbn, book);
		}
		
		return new ResponseEntity(book, HttpStatus.OK);
	}
}
