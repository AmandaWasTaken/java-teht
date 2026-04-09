package system;

import java.util.ArrayList;
import model.Book;
import model.LibraryMember;

public class Library {
	
	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<LibraryMember> members = new ArrayList<LibraryMember>();

	public void add_book(Book book){
		books.add(book);
		System.out.println("New book added");
	}

	public void add_member(LibraryMember m){
		members.add(m);
		System.out.println("New member added");
	}

	public void borrow_book(Book book, LibraryMember memb){
		for(Book b : books){
			if(book.book_id == b.book_id){
				books.remove(b);
				System.out.println("Book borrowed");
				memb.borrowedBooks.add(book);
				return;
			}
		}		
	}

	public void return_book(Book b, LibraryMember memb){

		if(memb.borrowedBooks.contains(b)){
			memb.borrowedBooks.remove(b);
			books.add(b);
			System.out.println("Book returned");
		} else {
			System.out.println("This member did not borrow this book");
		}	
	}
}
