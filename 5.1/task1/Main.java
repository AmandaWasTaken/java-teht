import java.util.*;

class Counter extends Thread {

	private int start;
	private int end;
	private boolean is_even;

	public Counter(int start, int end, boolean is_even){
		this.start   = start;
		this.end 	 = end;
		this.is_even = is_even;
	}

	@Override
	public void run(){
		
		for(int i = start; i <= end; i++){
			if(is_even && i % 2 == 0){
				System.out.printf("Even: %d%-5s%n", i, "");
			} else if(!is_even && i % 2 != 0){
				System.out.printf("Odd: %d%n", i);
			}
		}

	}
}

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter starting number (integer)");
		int start = sc.nextInt();
		System.out.println("Enter last number (integer)");
		int end = sc.nextInt();

		Counter c1 = new Counter(start, end, true);
		Counter c2 = new Counter(start, end, false);
		c1.start();
		c2.start();
	}
}
