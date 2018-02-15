package com.techqa.rest.dao;

import java.util.ArrayList;

import com.techqa.rest.domain.Book;

public interface IBookDAO {
	
	public ArrayList<Book> findAllBooks();

	public Book findBook(int index);

	public void addBook(Book book);

	public Book updateBook(Book book);

	public void removeBook(int index);

}
