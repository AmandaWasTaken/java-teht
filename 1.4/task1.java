import java.util.Scanner;

class main {

	public static final String[] lastNames = {"Mäkinen",
									   		  "Virtanen",
									   		  "Korhonen",
									   		  "Nieminen",
									   		  "Mäkelä",
									   		  "Laine",
									   		  "Hämäläinen",
									   		  "Heikkinen",
									   		  "Koskinen",
									   		  "Järvinen",
											  "Sandell",
	};

	public static final String[] firstNames = {"Juhani",
									    	   "Johannes",
											   "Maria",
											   "Helena",
											   "Olavi",
											   "Antero",
											   "Johanna",
											   "Anneli",
											   "Tapani",
											   "Kaarina",
											   "Amanda",
	};

	private static void generate_names(int n_names){

		final int min = 1;
		final int max = firstNames.length > lastNames.length ?
						firstNames.length : lastNames.length;
		String first, last;
		int r_firstName, r_lastName;

		for(int i = 0; i < n_names; i++){
			r_firstName = (int) ((Math.random() * (max - min)) + min);
			r_lastName  = (int) ((Math.random() * (max - min)) + min);
			first = firstNames[r_firstName];
			last = lastNames[r_lastName];
			System.out.printf("Generated name: %s %s%n", first, last);
		}
	}

	public static void main (String[] args) {
		
		int n_names = 0;
		Scanner sc = new Scanner(System.in);
		System.out.printf("How many names to generate?%n");
		n_names = sc.nextInt();
		generate_names(n_names);
	}	
}
