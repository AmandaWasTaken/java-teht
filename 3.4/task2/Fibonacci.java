import java.io.FileWriter;
import java.io.IOException;

class Fibonacci {
	
	static void compute_fibonacci(final int n) {
		
		final String filename = "./data/fibonacci.csv";

		try(FileWriter writer = new FileWriter(filename, true)){

			long a = 0;
			long b = 1;
			for(int i = 0; i < n; i++){
				writer.write(i + ";" + a + "\n");

				long next = a + b;
				a = b;
				b = next;
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		System.out.printf("Wrote %d Fibonacci numbers to %s%n", n, filename);
	}

	public static void main (String[] args) {
		
		compute_fibonacci(69);
	}
}
