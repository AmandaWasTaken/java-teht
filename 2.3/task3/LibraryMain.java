import java.util.ArrayList;

class Utils {
	
	public void _print_delim(final int DELIM_LEN){
		for(int i = 0; i < DELIM_LEN; i++) System.out.print("_");
		System.out.println();
	}

	public void _print_book_info(final Book b){

		// ts padding will probably break with long titles or author names lo
		System.out.printf("Title: %5s%s%n" + "Author: %4s%s%n" + 
						  "Published:  %d%n",
		"", b.get_title(), "", b.get_author(), b.get_year());
	}

	public int _true_book_count(ArrayList<Book> books){

		int cnt = 0;
		for(Book b : books){
			cnt += b.get_availability() ? 1 : 0;
		};
		return cnt;
	}

	public void _log_info(final String s){
		System.out.printf("[INFO]: %s%n", s);
	}
}

class Book {

	private String 	  title;
	private String 	  author;
	private int    	  year;
	private boolean   is_available;

	public Book(String title, String author, int year){
		this.title 	= title;
		this.author = author;
		this.year 	= year;
		this.is_available = true;
	}

	// Getters
	public String  get_title ()  	  { return this.title       ; }
	public String  get_author()  	  { return this.author      ; }
	public int     get_year  ()  	  { return this.year        ; }
	public boolean get_availability() { return this.is_available; }

	// Setters
	public void set_is_available(final boolean b){
		this.is_available = b; 
	}
}

class Library {

	private ArrayList<Book> books = new ArrayList<>();
	Utils utils = new Utils();

	public void add_book(String title, String author, int year){
		Book b = new Book(title, author, year);
		books.add(b);
	}

	public void display_books(){

		//	books.size() doesn't work properly since
		//	all books still exist but some are marked unavailable
//		System.out.printf("Books in library: %d%n", books.size());
		final int book_count = utils._true_book_count(books);
		if(book_count == 0){
			System.out.println("Book catalog is empty uh oh!");
			return;
		}

		System.out.printf("Books in library: %d%n", book_count);
		System.out.println("Library Catalog:");
		utils._print_delim(25);
		for(Book b : books){
			if(b.get_availability())
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

	public void borrow_book(final String title){
		
		for(Book b : books){
			if(b.get_title().equals(title)){
				if(b.get_availability()){
					System.out.printf("You borrowed book \"%s\"%n", b.get_title());
					b.set_is_available(false);
				} else {
					System.out.println("This book is unavailable!");
				}
				break;
			}
		}
	}

	public void return_book(final String title){
		for(Book b : books){
			if(b.get_title().equals(title)){
				if(!(b.get_availability())){
					System.out.printf("You returned book \"%s\"%n", b.get_title());
					b.set_is_available(true);
				} else {
					System.out.println("This book hasn't been borrowed!");
				}
				break;
			}
		}
	}

	public boolean check_availability(String title){

		for(Book b : books){
			if(!(b.get_title().equals(title))) continue;
			return b.get_availability();
		}
		return false;
	}
}

class LibraryMain {

	public static void main (String[] args) {

		Utils utils = new Utils();
		Library lib = new Library();

		lib.add_book("Book 1", "Me", 2006);
		lib.add_book("Book 2", "Me", 1234);
		lib.add_book("Book 3", "You", 1967);
		utils._log_info("Added 3 new books to library");
		utils._log_info("Displaying all books in library");
		lib.display_books();
		utils._log_info("Borrowing book \"Book 1\"");
		lib.borrow_book("Book 1");
		utils._log_info("Displaying all books in library");
		lib.display_books();
		utils._log_info("Returning book \"Book 1\"");
		lib.return_book("Book 1");
		utils._log_info("Displaying all books in library");
		utils._log_info("Borrowing book \"Book 2\"");
		lib.borrow_book("Book 2");
		utils._log_info("Checking availability for \"Book 2\"");
		System.out.printf(lib.check_availability("Book 2") ? 
				"This book is available%n" : "This book is unavailable%n");
	}
}
