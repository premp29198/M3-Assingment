package com.author.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BookAuthor {

	@Id
	private Book book;
	private Author2 author;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Author2 getAuthor() {
		return author;
	}
	public void setAuthor(Author2 author) {
		this.author = author;
	}
	
	
}
