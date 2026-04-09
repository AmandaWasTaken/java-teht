package model;

public class Book {
	
	private String title;
	private String author;
	private	int ISBN;
	public static int book_id = 1;

	public Book(String title, String author, int ISBN){
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.book_id += 1;
	}
}

