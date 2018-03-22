package com.kcn.mybooksrestapp.dao;

import java.util.List;

import com.kcn.mybooksrestapp.entity.Book;

public interface BookDAO {
	
	public List<Book> getBooks();

	public void saveBook(Book b);

	public Book getBook(String isbn);

	public void deleteBook(String theIsbn);

	public void updateBook(String isbn, Book book);
	
}
