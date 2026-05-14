import java.util.ArrayList;
import java.util.Random;

class Main {

	static final int MAX_LEN = 16;

	static void print_list(ArrayList<Integer> arr){
		for(int i : arr) System.out.printf("%d%n", i);
		System.out.println();
	}

	public static void main (String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Random r = new Random();

		for(int i = 0; i < MAX_LEN; i++){
			arr.add(r.nextInt(128) + 1);
		}

		System.out.println("List:");
		print_list(arr);

		arr.removeIf(n -> (n % 2 == 0));
		System.out.println("List after removing evens:");
		print_list(arr);

		arr.replaceAll(n -> n << 1);
		System.out.println("List after doubling the others:" );
		print_list(arr);

		int sum = arr
			.stream()
			.mapToInt(n -> n)
			.sum();

		System.out.printf("Sum: %d%n", sum);
	}
}
