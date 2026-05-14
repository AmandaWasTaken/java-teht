import java.util.Random;
import java.util.Arrays;

public class Main {

	static final int LIMIT = 16;

	// i'm also doing the non-funcional way to verify that the
	// functional solution works as expected
	static double calculate_mean(int[] arr){

		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		return (double) sum/arr.length;
	}

	static double calculate_mean_fp(int[] arr){

		return 
			(double) arr.length == 0 ? 0.0 :
			(double) (Arrays.stream(arr).reduce(0, (acc, n) -> acc + n)) / arr.length;
	}

	public static void main(String[] args) {
		
		Random r = new Random();
		int[] arr = new int[LIMIT];

		// Using a loop to populate the array but not for the actual calculations
		for(int i = 0; i < LIMIT; i++){
			arr[i] = r.nextInt(128) + 1;
		}

		double mean_fp = calculate_mean_fp(arr);
		double mean = calculate_mean(arr);

		System.out.printf("fp: %.2f%nnormal: %.2f%n",mean_fp, mean);
		
	}
}
