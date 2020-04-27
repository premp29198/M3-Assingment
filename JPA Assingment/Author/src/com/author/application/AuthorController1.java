package com.author.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.author.bean.Book;
import com.author.dao.AuthorCrud2;

public class AuthorController1 {

	public static void main(String... args){
		int id;
		List<Book> books;
		AuthorCrud2 authCrud = new AuthorCrud2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\t\t1.Retrive All Books.\t2.Query All Books Witten by Author\n\t\t3.List books in range 500 to 1000\t4.List Author Name using book ID");
		System.out.println(": Enter your choice");
		int choice;
		try {
			choice = Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1: books = authCrud.getAllBooks();
					for(Book book:books)
					{
						System.out.println("\t\tBook Title : "+book.getTitle());
					}
					break;
			case 2 : break;
			case 3 : books = authCrud.getBooksInRange();
					if(books.size() > 0){
					for(Book book:books)
					{
						System.out.println("\t\tBook ISBN : "+ book.getIsbn() + " Book Title : "+book.getTitle() + " Book Price : " + book.getPrice());
					}
					}
					else
						System.out.println("\t\tNo Book in this price range");
					break;
			case 4 : System.out.print("\t\tEnter Book Id : ");
					 id = Integer.parseInt(br.readLine());
					 String authName = authCrud.getAuthorByBookId(id);
					 if(authName != null)
						 System.out.println("\t\tAuthor Name : "+authName);
					 else
						 System.out.println("\t\tThis Book doesn't exist");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
}
