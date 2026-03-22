import java.util.Scanner;

class main {

	private static void die(final String err){
		System.out.println("Error! " + err);
		System.exit(1);
	}

	private static void print_arr(int[] nums){

		int idx = 0;
		System.out.println("Primes in given range: ");
		while(nums[idx++] != 0) System.out.println(nums[idx - 1]);

	}

	private static int[] initialize_array(int n){

		int[] res = new int[n + 1];
		for(int i = 2; i <= n; i++){
			res[i] = 1;
		}
		return res;
	}

	// Compute primes with the sieve of eratosthenes algorithm
	private static int[] sieve(int n, int[] nums, int start){

		for(int p = 2; p*p <= n; p++){
			if(nums[p] != 0){
				for(int i = p*p; i <= n; i += p){
					nums[i] = 0;
				}
			}
		}

		int count = 0;
		for(int i = 2; i <= n; i++) 
			if(nums[i] == 1 && i >= start) count++;
		
		int[] res = new int[count + 1];
		int idx = 0;
		for(int i = 2; i <= n; i++){
			if(nums[i] == 1 && i >= start) res[idx++] = i;
		}
		res[idx] = 0;
		return res;
	}
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int start, end;
		System.out.println("Input start index");
		start = sc.nextInt();
		if(start < 0) die("Input must be greater than 0"); 
		System.out.println("Input end index");
		end = sc.nextInt();
		if(end < 0) die("Input must be greater than 0"); 
		if(start > end) die("Start index must be lower than end");
		
		int n = end; 
		int nums[] = initialize_array(n);
		int res[] = sieve(n, nums, start);
		print_arr(res);	
	}
}
