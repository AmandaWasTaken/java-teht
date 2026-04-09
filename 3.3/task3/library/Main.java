import model.Book;
import model.LibraryMember;
import system.Library;


public class Main {

	public static void main (String[] args) {

		Library lib = new Library();
		Book b = new Book("Clean Code", "Robert C. Martin", 1234);
		LibraryMember mem = new LibraryMember("Amanda", 69);

		lib.add_member(mem);
		lib.add_book(b);
		lib.borrow_book(b, mem);
		lib.return_book(b, mem);
		lib.reserve_book(b, mem);
		lib.get_reservations(mem);
		lib.cancel_reservation(b, mem);
		lib.get_reservations(mem);

	}	
}


