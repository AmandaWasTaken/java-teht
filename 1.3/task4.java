import java.util.Scanner;

class main{
	
	public static boolean check_answer(int actual, int expected){
		return actual == expected;
	}

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int score = 0;
		int round = 0;
		int ans;
		int rand1, rand2;
		boolean won = false;

		while(!won){
			rand1 = (int) (Math.random() * 10) + 1;
			rand2 = (int) (Math.random() * 10) + 1;
			System.out.println("Question " + (round+1) + ":\n" + 
								rand1 + "*" + rand2);
			ans = sc.nextInt();
			boolean correct = check_answer(ans, rand1 * rand2);
			System.out.println(correct ?
					"Correct!" : "Incorrect");
			if(correct) score++;

			if(score == 10){
				System.out.println("You Won!");
				won = true;
			}

			round++;
			if(round == 10 && score < 10){
				System.out.println("\nYou Failed, Try Again! (Score " + score + "/10)\n");
				round = 0;
			}
		}	
	}
}
