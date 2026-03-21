import java.util.Scanner;

class main {

	private static float _length(final float leg1, final float leg2){
		return (float) Math.sqrt(leg1 * leg1 + leg2 * leg2);
	}

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		float leg1, leg2;
		System.out.println("Input the length of leg 1 ");
		leg1 = sc.nextInt();
		System.out.println("Input the length of leg 2");
		leg2 = sc.nextInt();
		float len = _length(leg1, leg2);
		System.out.println("Length of hypotenuse: " + len);

	}
}
