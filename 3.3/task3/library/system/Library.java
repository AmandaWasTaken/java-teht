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
		System.out.printf("New member added%nWelcome, %s!%n%n", m.getName());
	}

	public void borrow_book(Book book, LibraryMember memb){
		for(Book b : books){
			if(book.book_id == b.book_id){
				books.remove(b);
				System.out.println("Book borrowed");
				memb.borrowedBooks.add(book);
				return;
			} else {
				System.out.println("This book cannot be borrowed at this time");
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
		return;
	}
	
	public void reserve_book(Book b, LibraryMember memb){
		
		if(books.contains(b) && !b.reserved){
			b.reserved = true;
			memb.reservations.add(b);
			System.out.println("Book reserved");
		} else {
			System.out.println("Book not found or already reserved");
		}
		return;
	}

	public void cancel_reservation(Book b, LibraryMember memb){

		if(memb.reservations.contains(b)){
			b.reserved = false;
			memb.reservations.remove(b);
			System.out.println("You have cancelled your reservation");
		} else {
			System.out.println("You have not reserved this book");
		}
		return;
	}

	public void get_reservations(LibraryMember memb){

		if(memb.reservations.size() <= 0){
			System.out.println("This member has no reservations");
			return;
		}

		System.out.printf("%nResevations for member %s:%n", memb.getName());
		for(Book b : memb.reservations){
			System.out.println(b);
		}
	}
}


