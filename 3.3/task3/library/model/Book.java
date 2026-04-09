package model;

public class Book {
	
	private String title;
	private String author;
	private	int ISBN;
	public boolean reserved;

	public static int book_id = 1;

	public Book(String title, String author, int ISBN){
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.book_id += 1;
		this.reserved = false;
	}

	private String getTitle	() { return this.title ; }
	private String getAuthor() { return this.author; }
	private int getISBN		() { return this.ISBN  ; }

	@Override
	public String toString(){
		return "\nTitle: " + getTitle() + "\nAuthor: " + getAuthor() + "\nISBN: " +
			getISBN();
	}
}

