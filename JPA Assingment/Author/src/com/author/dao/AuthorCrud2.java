package com.author.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.author.bean.Author1;
import com.author.bean.Book;

public class AuthorCrud2 {

	static EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("AuthorJPA");
	static EntityManager entityManager= emfactory.createEntityManager();
	public Author1 getAuthorDetails(int authorId){
		Author1 author = entityManager.find(Author1.class, authorId);
		return author;
	}
	public List<Book> getAllBooks(){
		Query bookQuery = entityManager.createNamedQuery("Book.findAll");
		List books = bookQuery.getResultList();
		return books;
	}
	
	/*public List<?> getBooksByAuthor(int authId)
	{
		Query query = entityManager.
			      createQuery("Select b.title from Book b where b.isbn in (select ba.book.isbn where"
			      		+ "ba.)");
	}*/
	
	public List<Book> getBooksInRange(){
		 Query query = entityManager.createQuery( "Select b from Book b  where b.price Between 500 and 1000" );
	      
	      List<Book> list=(List<Book>)query.getResultList( );
	      return list;
	}
	public String getAuthorByBookId(int isbn){
		Query query = entityManager.createQuery( "Select ba.author.name from BookAuthor ba  where ba.book.isbn="+isbn);
		String authName = (String) query.getSingleResult();
		return authName;
	}
}
