package model;
import java.util.HashMap;

public class DictModel {
	
	private static HashMap<String, String> words = new HashMap<>();
 
	static {
		debug("Initializing");

		// I tried a billion different ways to initialize
		// the map with words but none of them worked and 
		// i can not get it to work no matter what i do
		// so it's unfortunately "unfinished"
		words.put("Java",
					"Java is a high-level general purpose object oriented programming language");
		words.put("JavaFX",
					"JavaFX is a software platform for creating desktop and web applications");
		words.put("Metropolia",
					"Metropolia is a University of Applied Sciences based in Helsinki and Espoo, Finland");

	}

	private static void debug(final String str){
		System.out.printf("[DEBUG]: %s%n", str);
	}

	public static void add_word(final String word, final String definition){
		words.put(word, definition);
	}

	public String get_word(final String word){
		return words.get(word.toLowerCase());
	}
}
