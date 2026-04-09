package model;
import java.util.ArrayList;

public class LibraryMember {
	
	private String name;
	private int memberID;
	public ArrayList<Book> borrowedBooks; 
	public ArrayList<Book> reservations; 

	public LibraryMember(String name, int memberID){
		this.name = name;
		this.memberID = memberID;
		this.borrowedBooks = new ArrayList<Book>();
		this.reservations = new ArrayList<Book>();
	}

	public String getName() { return this.name; }
}
