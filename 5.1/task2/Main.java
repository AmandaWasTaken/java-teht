import java.util.*;

class Summation extends Thread {

	private int sum = 0;
	private int id;
	private final int start;
	private final int end;
	private final int[] nums;

	public Summation(int start, int end, int[] nums, int id){
		this.start = start;
		this.end = end;
		this.nums = nums;
		this.id = id;
	}

	public int get_sum() { return sum; }

	@Override
	public void run(){
		
		System.out.printf("Thread %d starting%n", id);
		for(int i = start; i < end; i++){
			sum += nums[i];
		}
	}
}

public class Main {

	public static void populate_arr(int[] nums){
		
		Random r = new Random();

		for(int i = 0; i < nums.length; i++){
			int num = r.nextInt(128);
			nums[i] = num;
		}
	}

	public static void main (String[] args) {
		
		final int n_processors = Runtime.getRuntime().availableProcessors();
		final int total_size   = n_processors * 1000000;
		final int chunk_size   = total_size/n_processors;
		System.out.printf("Processors: %d%n", n_processors);
		int[] nums = new int[total_size];
		populate_arr(nums);
		Summation[] threads = new Summation[n_processors];

		for(int i = 0; i < n_processors; i++){
			int start = i * chunk_size;
			int end = (i == n_processors - 1) ? total_size : start + chunk_size;
			threads[i] = new Summation(start, end, nums, i);
			threads[i].start();
		}	

		for(int i = 0; i < n_processors; i++){
			try {
				threads[i].join();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}

		int total = 0;
		for(int i = 0; i < n_processors; i++){
			total += threads[i].get_sum();
		}

		System.out.printf("Sum: %d%n", total);
	}
}
