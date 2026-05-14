import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Person {

	private String name;
	public  String city;
	private int    age;


	public Person(String name, String city, int age){
		this.name = name;
		this.age  = age;
		this.city = city;
	}

	public int get_age() { return age; }
	public String get_city() { return city; }

	@Override
	public String toString() { return name + " - " + age; }

	public static void print_list(ArrayList<Person> people){
		for(Person p : people){
			System.out.printf("%s%n", p.toString());
		}
	}
}

public class Main {

	public static void main (String[] args) {

		ArrayList<Person> people = new ArrayList<Person>();
		people.add(new Person("Amanda",  "Espoo",     23));
		people.add(new Person("Bob",     "Chicago",   36));
		people.add(new Person("Alice",   "Oslo",      19));
		people.add(new Person("Melinda", "London",    24));
		people.add(new Person("Francis", "Sao Paulo", 31));

		people.sort(Comparator.comparingInt(Person::get_age));
		System.out.println("Sorted");
		Person.print_list(people);

		people.removeIf(person -> !person.get_city().equals("Espoo"));
		System.out.println("Removed");
		Person.print_list(people);
	}
}






