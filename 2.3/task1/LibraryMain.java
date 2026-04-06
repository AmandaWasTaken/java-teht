import java.util.ArrayList;

class Utils {
	
	public void _print_delim(final int DELIM_LEN){
		for(int i = 0; i < DELIM_LEN; i++) System.out.print("_");
		System.out.println();
	}

	public void _print_book_info(Book b){

		// ts padding will probably break with long titles or author names lo
		System.out.printf("Title: %5s%s%n" + "Author: %4s%s%n" + 
						  "Published:  %d%n",
		"", b.get_title(), "", b.get_author(), b.get_year());
	}
}

class Book {

	private String title;
	private String author;
	private int    year;

	public Book(String title, String author, int year){
		this.title 	= title;
		this.author = author;
		this.year 	= year;
	}

	public String get_title ()  { return this.title ; }
	public String get_author()  { return this.author; }
	public int    get_year  () 	{ return this.year  ; }

}

class Library {

	private ArrayList<Book> books = new ArrayList<>();
	Utils utils = new Utils();

	public void add_book(String title, String author, int year){
		Book b = new Book(title, author, year);
		books.add(b);
	}

	public void display_books(){

		System.out.printf("Books in library: %d%n%n", books.size());
		System.out.println("Library Catalog:");
		utils._print_delim(25);
		for(Book b : books){
			utils._print_book_info(b);
			System.out.println();
		}
		utils._print_delim(25);
	}

	public void find_by_author(String author){
		
		System.out.printf("Books from author \"%s\"%n", author);	
		utils._print_delim(25);

		int cnt = 0;
		for(Book b : books){
			if(b.get_author() != author) continue;

			utils._print_book_info(b);
			System.out.println();
			cnt++;
		}

		if(cnt == 0) System.out.println("No books from given author");
		utils._print_delim(25);
	}
}

class LibraryMain {

	public static void main (String[] args) {
		Library lib = new Library();
		lib.add_book("Title", "Me", 2006);
		lib.add_book("New title", "Me", 1234);
		lib.add_book("Other title", "You", 1967);
		lib.display_books();
	}
}






