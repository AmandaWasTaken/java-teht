import java.util.Scanner;

class main {

	private static Scanner sc = new Scanner(System.in);

	private static int[] build_arr(int n){

		int[] res = new int[n];
		for(int i = 0; i < n; i++){
			System.out.printf("Enter integer %d: %n", i + 1);
			res[i] = sc.nextInt();
		}
		return res;
	}

	private static int[] max_subarray(int[] arr){

		int current = arr[0];
		int max_sum = arr[0];

		int start = 0;
		int end = 0;
		int tmp = 0;

		for(int i = 1; i < arr.length; i++){
			if(arr[i] > current + arr[i]){
				current = arr[i];
				tmp = i;
			} else {
				current += arr[i];
			}

			if(current > max_sum){
				max_sum = current;
				start = tmp;
				end = i;
			}
		}
		return new int[]{max_sum, start + 1, end + 1};
	}

	public static void main (String[] args) {
		
		int sz;
		System.out.print("Enter the size of the array: ");
		sz = sc.nextInt();
		
		int[] arr = build_arr(sz);
		int[] res = max_subarray(arr);

		System.out.printf("Maximum sum: %d%n", res[0]);
		/*System.out.printf("Start: %d%n", res[1]);
		System.out.printf("End: %d%n", res[2]);
		*/
		System.out.printf("Integers: %d-%d%n", res[1], res[2]);
	}
}




