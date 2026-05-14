import java.util.Random;
import java.util.ArrayList;

class Main {

	private final static int MAX_LEN = 10;

	public static void print_list(ArrayList<Integer> nums){
		for(int i : nums){
			System.out.printf("%d%n", i);
		}
		System.out.println();
	}

	public static void main (String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < MAX_LEN; i++){
			nums.add(r.nextInt(128) + 1);
		}	
		
		System.out.println("List: ");
		print_list(nums);

		nums.removeIf(n -> (n % 2 == 0));
		System.out.println("List after removing evens: ");
		print_list(nums);

		nums.replaceAll(n -> n * 2);
		System.out.println("List after doubling odds: ");
		print_list(nums);

		int sum = nums
			.stream()
			.mapToInt(n -> n)
			.sum();

		System.out.printf("Sum: %d%n", sum);

	}
}
