import java.util.Scanner;

class main {

	private static float _convert(final float f){
		return ((f - 32) * 5)/9;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Input temperature in Fahrenheit");
		float f = sc.nextFloat();

		float c = _convert(f);
		System.out.println(f + " Fahrenheit is " + 
				String.format("%.1f", c) + " Celsius");
	}	
}
