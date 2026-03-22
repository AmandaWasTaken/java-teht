import java.util.Scanner;

class main {

	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		double a, b, c;
		System.out.println("Input coefficient a ");
		a = sc.nextDouble();
		System.out.println("Input coefficient b ");
		b = sc.nextDouble();
		System.out.println("Input coefficient c ");
		c = sc.nextDouble();
		
		double discrim = b*b - 4*a*c;
		if(discrim > 0){
			double x1 = (-b + Math.sqrt(discrim)) / (2*a);
			double x2 = (-b - Math.sqrt(discrim)) / (2*a);
			System.out.println("Two real roots\n" + 
					String.format("%.0f", x1) + ", " + 
					String.format("%.0f", x2)); 
		} else if (discrim == 0){
			double x = -b / (2*a);
			System.out.println("One real root\n" + x);
		} else {
			System.out.println("No real roots");
		}	
	}
}
