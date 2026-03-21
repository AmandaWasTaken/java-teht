import java.util.Scanner;

class main {

	private static final float luoti = 13.28f;
	private static final float naula = 32 * luoti;
	private static final float leiviska = 20 * naula; 

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		float grams;
		System.out.println("Weight (g): ");
		grams = sc.nextInt();


		float n_leiv = grams/leiviska;
		float rem = grams % leiviska;

		float n_naula = rem/naula;
		rem = rem % naula;

		float n_luoti = rem / luoti;
		System.out.println(String.format("%.0f", grams) + " grams is " + 
			String.format("%.0f", n_leiv)  + " leiviskä, " +
			String.format("%.0f", n_naula) + " naula, and " + 
			String.format("%.2f", n_luoti) + " luoti"); 
	}
}
