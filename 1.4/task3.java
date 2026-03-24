import java.util.Scanner;

class main {
	
	private static void print(final String str){
		System.out.print(str + "\n");
	}

	private static void print_arr(final int[] nums){

		for(int i = 0; i < nums.length; i++){
			print("" + nums[i]);
		}
	}

	private static boolean _contains(int[] nums, int x){

		for(int i = 0; i < nums.length; i++){
			if(nums[i] == x) return true;
		}
		return false;
	}

	private static int[] remove_dupes(int[] nums){

		int[] tmp = new int[nums.length];
		int cnt = 0;

		for(int i = 0; i < nums.length; i++){
			if(!_contains(tmp, nums[i])){
				tmp[cnt++] = nums[i];
			}
		}

		int[] res = new int[cnt];
		for(int i = 0; i < cnt; i++){
			res[i] = tmp[i];
		}
		return res;
	}

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		print("Enter the size of the array: ");
		int sz = sc.nextInt();
		int[] nums = new int[sz];

		print("Enter the integers into the array:");
		for(int i = 0; i < sz; i++){
			print("Enter interger " + (i+1) + ":");
			nums[i] = sc.nextInt();
		}

		int[] res = remove_dupes(nums);
		print("The array without duplicates:");
		print_arr(res);
	}
}
